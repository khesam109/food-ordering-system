package com.food.ordering.system.order.service.domain;

import com.food.ordering.system.order.service.domain.event.OrderCreatedEvent;
import com.food.ordering.system.order.service.domain.ports.output.message.publisher.payment.OrderCreatedPaymentRequestMessagePublisher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

@Slf4j
@Component
public class OrderCreatedEventApplicationListener {

    private final OrderCreatedPaymentRequestMessagePublisher orderCreatedPaymentRequestMessagePublisher;

    @Autowired
    public OrderCreatedEventApplicationListener(
            OrderCreatedPaymentRequestMessagePublisher orderCreatedPaymentRequestMessagePublisher
    ) {
        this.orderCreatedPaymentRequestMessagePublisher = orderCreatedPaymentRequestMessagePublisher;
    }

    /**
     * This method will only be called when the method that publishes the application event
     * is completed and the transaction is committed
     */
    @TransactionalEventListener
    public void process(OrderCreatedEvent orderCreatedEvent) {

    }
}
