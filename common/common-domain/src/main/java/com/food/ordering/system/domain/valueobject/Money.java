package com.food.ordering.system.domain.valueobject;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Objects;

public class Money {

    public static final Money ZERO = new Money(BigDecimal.ZERO);

    private final BigDecimal amount;

    public Money(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * NOTE: compareTo vs equals in BigDecimal
     */
    public boolean isGreaterThanZero() {
        return this.amount != null && this.amount.compareTo(BigDecimal.ZERO) > 0;
    }

    /**
     * TODO: shouldn't need to check for being null of input param?
     */
    public boolean isGreaterThan(Money money) {
        return this.amount != null && this.amount.compareTo(money.getAmount()) > 0;
    }

    public Money add(Money money) {
        return new Money(
                setScale(
                        this.amount.add(money.getAmount())
                )
        );
    }

    public Money subtract(Money money) {
        return new Money(
                setScale(
                        this.amount.subtract(money.getAmount())
                )
        );
    }

    public Money multiply(int multiplier) {
        return new Money(
                setScale(
                        this.amount.multiply(new BigDecimal(multiplier))
                )
        );
    }

    public BigDecimal getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return amount.equals(money.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }

    /**
     * NOTE: <a href="http://www.aligelenler.com/2014/10/using-fractional-numbers-in-java_14.html">
     *     Using Fractional Numbers In Java
     *     </a>
     */
    private BigDecimal setScale(BigDecimal input) {
        return input.setScale(2, RoundingMode.HALF_EVEN);
    }
}
