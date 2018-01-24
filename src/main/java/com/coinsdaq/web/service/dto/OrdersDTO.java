package com.coinsdaq.web.service.dto;


import com.coinsdaq.web.domain.enumeration.OrderCondition;
import com.coinsdaq.web.domain.enumeration.OrderState;
import com.coinsdaq.web.domain.enumeration.OrderStrategy;
import com.coinsdaq.web.domain.enumeration.OrderType;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * A DTO for the Orders entity.
 */
public class OrdersDTO implements Serializable {

    private Long id;

    private BigDecimal quantity;

    private BigDecimal quantityRemaining;

    private BigDecimal rate;

    private OrderState state;

    private OrderType type;

    private OrderStrategy strategy;

    private OrderCondition condition;

    private String marketCurrency;

    private String baseCurrency;

    private LocalDate createAt;

    private LocalDate updatedAt;

    private LocalDate doneAt;

    private Boolean locked;

    private Set<ExchangeDTO> exchanges = new HashSet<>();

    private Long marketId;

    private Long userId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getQuantityRemaining() {
        return quantityRemaining;
    }

    public void setQuantityRemaining(BigDecimal quantityRemaining) {
        this.quantityRemaining = quantityRemaining;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public OrderState getState() {
        return state;
    }

    public void setState(OrderState state) {
        this.state = state;
    }

    public OrderType getType() {
        return type;
    }

    public void setType(OrderType type) {
        this.type = type;
    }

    public OrderStrategy getStrategy() {
        return strategy;
    }

    public void setStrategy(OrderStrategy strategy) {
        this.strategy = strategy;
    }

    public OrderCondition getCondition() {
        return condition;
    }

    public void setCondition(OrderCondition condition) {
        this.condition = condition;
    }

    public String getMarketCurrency() {
        return marketCurrency;
    }

    public void setMarketCurrency(String marketCurrency) {
        this.marketCurrency = marketCurrency;
    }

    public String getBaseCurrency() {
        return baseCurrency;
    }

    public void setBaseCurrency(String baseCurrency) {
        this.baseCurrency = baseCurrency;
    }

    public LocalDate getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDate createAt) {
        this.createAt = createAt;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
    }

    public LocalDate getDoneAt() {
        return doneAt;
    }

    public void setDoneAt(LocalDate doneAt) {
        this.doneAt = doneAt;
    }

    public Boolean isLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    public Set<ExchangeDTO> getExchanges() {
        return exchanges;
    }

    public void setExchanges(Set<ExchangeDTO> exchanges) {
        this.exchanges = exchanges;
    }

    public Long getMarketId() {
        return marketId;
    }

    public void setMarketId(Long marketId) {
        this.marketId = marketId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long memberId) {
        this.userId = memberId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        OrdersDTO ordersDTO = (OrdersDTO) o;
        if(ordersDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), ordersDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "OrdersDTO{" +
            "id=" + getId() +
            ", quantity=" + getQuantity() +
            ", quantityRemaining=" + getQuantityRemaining() +
            ", rate=" + getRate() +
            ", state='" + getState() + "'" +
            ", type='" + getType() + "'" +
            ", strategy='" + getStrategy() + "'" +
            ", condition='" + getCondition() + "'" +
            ", marketCurrency='" + getMarketCurrency() + "'" +
            ", baseCurrency='" + getBaseCurrency() + "'" +
            ", createAt='" + getCreateAt() + "'" +
            ", updatedAt='" + getUpdatedAt() + "'" +
            ", doneAt='" + getDoneAt() + "'" +
            ", locked='" + isLocked() + "'" +
            "}";
    }
}
