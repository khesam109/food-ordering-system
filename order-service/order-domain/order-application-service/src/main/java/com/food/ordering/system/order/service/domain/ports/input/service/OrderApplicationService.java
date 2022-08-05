package com.food.ordering.system.order.service.domain.ports.input.service;

import com.food.ordering.system.order.service.domain.dto.create.CreateOrderCommand;
import com.food.ordering.system.order.service.domain.dto.create.CreateOrderResponse;
import com.food.ordering.system.order.service.domain.dto.track.TrackOrderQuery;
import com.food.ordering.system.order.service.domain.dto.track.TrackOrderResponse;

import javax.validation.Valid;

public interface OrderApplicationService {

    /**
     * Valid annotation should be placed on interface not implementation
     * <a href="https://beanvalidation.org/1.1/spec/#constraintdeclarationvalidationprocess-methodlevelconstraints-inheritance">Bean Validation specification</a>
     * <a href="https://github.com/UniKnow/AgileDev/issues/3">Exception occurs when constraint set on overridden method</a>
     */
    CreateOrderResponse createOrder(
            @Valid CreateOrderCommand createOrderCommand
    );

    TrackOrderResponse trackOrder(
            @Valid TrackOrderQuery trackOrderQuery
    );
}
