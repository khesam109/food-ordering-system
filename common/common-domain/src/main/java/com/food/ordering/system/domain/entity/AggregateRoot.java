package com.food.ordering.system.domain.entity;

/**
 * Simply this class is similar to Entity but just work as a marker
 * to distinguish especial kind of entity which is Aggregate Root
 */
public abstract class AggregateRoot<ID> extends BaseEntity<ID> {
}
