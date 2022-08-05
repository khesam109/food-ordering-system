package com.food.ordering.system.order.service.domain.dto.track;

import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@Jacksonized
public class TrackOrderQuery {

    @NotNull private final UUID orderTrackingId;
}
