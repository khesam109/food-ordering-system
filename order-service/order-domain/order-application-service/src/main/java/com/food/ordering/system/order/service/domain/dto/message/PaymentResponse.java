package com.food.ordering.system.order.service.domain.dto.message;

import com.food.ordering.system.domain.valueobject.PaymentStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@Getter
@Builder
@Jacksonized
public class PaymentResponse {

    private String id;
    private String sagaId;
    private String orderId;
    private String paymentId;
    private String customerId;
    private BigDecimal price;
    private Instant createdAt;
    private PaymentStatus paymentStatus;
    private List<String> failureMessages;
}
