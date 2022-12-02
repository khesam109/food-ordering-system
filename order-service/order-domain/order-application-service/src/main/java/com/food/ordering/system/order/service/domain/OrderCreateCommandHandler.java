package com.food.ordering.system.order.service.domain;

import com.food.ordering.system.order.service.domain.dto.create.CreateOrderCommand;
import com.food.ordering.system.order.service.domain.dto.create.CreateOrderResponse;
import com.food.ordering.system.order.service.domain.event.OrderCreatedEvent;
import com.food.ordering.system.order.service.domain.mapper.OrderDataMapper;
import com.food.ordering.system.order.service.domain.outbox.scheduler.payment.PaymentOutboxHelper;
import com.food.ordering.system.outbox.OutboxStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Slf4j
@Component
public class OrderCreateCommandHandler {

    private final OrderCreateHelper orderCreateHelper;
    private final OrderDataMapper orderDataMapper;
    private final PaymentOutboxHelper paymentOutboxHelper;
    private final OrderSagaHelper orderSagaHelper;

    @Autowired
    public OrderCreateCommandHandler(
            OrderCreateHelper orderCreateHelper,
            OrderDataMapper orderDataMapper,
            PaymentOutboxHelper paymentOutboxHelper,
            OrderSagaHelper orderSagaHelper) {
        this.orderCreateHelper = orderCreateHelper;
        this.orderDataMapper = orderDataMapper;
        this.paymentOutboxHelper = paymentOutboxHelper;
        this.orderSagaHelper = orderSagaHelper;
    }

    /**
     * <a href="https://stackoverflow.com/questions/3423972/spring-transaction-method-call-by-the-method-within-the-same-class-does-not-wo">
     *     Invocations transaction within the same class</a>
     * Delegating the persistent of order to OrderCreateHelper (withing a transaction) to make
     * sure that changes are committed before publishing event.
     * Firing event and then trying to commit the save operation on local database could lead to a inconsistent state
     * **************************************************************************************************************
     * This caller method is not Transactional before implementing outbox pattern. But after implementing the outbox
     * pattern things goes different. The idea behind using outbox table is to have a Single ACID transaction for both
     * local database operations and for outbox table.
     *
     */
    @Transactional
    public CreateOrderResponse createOrder(CreateOrderCommand createOrderCommand) {
        OrderCreatedEvent orderCreatedEvent = orderCreateHelper.persistOrder(createOrderCommand);
        log.info("Order is created with id: {}", orderCreatedEvent.getOrder().getId().getValue());
        CreateOrderResponse createOrderResponse = orderDataMapper.orderToCreateOrderResponse(
                orderCreatedEvent.getOrder(),
                "Order created successfully"
        );

        paymentOutboxHelper.savePaymentOutboxMessage(
                orderDataMapper.orderCreatedEventToOrderPaymentEventPayload(orderCreatedEvent),
                orderCreatedEvent.getOrder().getOrderStatus(),
                orderSagaHelper.orderStatusToSagaStatus(orderCreatedEvent.getOrder().getOrderStatus()),
                OutboxStatus.STARTED,
                UUID.randomUUID()
        );

        log.info("Returning CreateOrderResponse with order id: {}", orderCreatedEvent.getOrder().getId().getValue());

        return createOrderResponse;
    }
}
