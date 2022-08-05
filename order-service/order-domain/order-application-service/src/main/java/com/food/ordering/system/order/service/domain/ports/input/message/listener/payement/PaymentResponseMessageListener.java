package com.food.ordering.system.order.service.domain.ports.input.message.listener.payement;

import com.food.ordering.system.order.service.domain.dto.message.PaymentResponse;

import javax.validation.Valid;

public interface PaymentResponseMessageListener {

    void paymentCompleted(
            @Valid PaymentResponse paymentResponse
    );

    void paymentCancelled(
            @Valid PaymentResponse paymentResponse
    );
}
