package com.coinsdaq.web.service.dto;


import com.coinsdaq.web.domain.enumeration.OrderType;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * A DTO for the OrderBook entity.
 */
public class OrderBookDTO implements Serializable {

    private Long id;

    private OrderType type;

    private BigDecimal quantity;

    private BigDecimal rate;

    private Long marketId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OrderType getType() {
        return type;
    }

    public void setType(OrderType type) {
        this.type = type;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public Long getMarketId() {
        return marketId;
    }

    public void setMarketId(Long marketId) {
        this.marketId = marketId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        OrderBookDTO orderBookDTO = (OrderBookDTO) o;
        if(orderBookDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), orderBookDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "OrderBookDTO{" +
            "id=" + getId() +
            ", type='" + getType() + "'" +
            ", quantity=" + getQuantity() +
            ", rate=" + getRate() +
            "}";
    }
}
