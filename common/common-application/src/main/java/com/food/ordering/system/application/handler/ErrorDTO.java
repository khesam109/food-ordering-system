package com.food.ordering.system.application.handler;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@Jacksonized
public class ErrorDTO {

    private final String code;
    private final String message;
}
