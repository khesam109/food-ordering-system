package com.food.ordering.system.order.service.domain.dto.create;

import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

@Getter
@Builder
@Jacksonized
public class OrderAddress {

    @Max(value = 50)
    @NotNull private final String street;

    @Max(value = 10)
    @NotNull private final String postalCode;

    @Max(value = 50)
    @NotNull private final String city;
}
