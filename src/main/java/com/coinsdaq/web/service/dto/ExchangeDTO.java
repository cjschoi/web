package com.coinsdaq.web.service.dto;


import com.coinsdaq.web.domain.enumeration.ExchangeState;
import com.coinsdaq.web.domain.enumeration.OrderType;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A DTO for the Exchange entity.
 */
public class ExchangeDTO implements Serializable {

    private Long id;

    private String marketCurrency;

    private String baseCurrency;

    private BigDecimal quantity;

    private BigDecimal rate;

    private OrderType orderType;

    private LocalDate createAt;

    private LocalDate doneAt;

    private ExchangeState state;

    private Long feeId;

    private Long ordererId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public OrderType getOrderType() {
        return orderType;
    }

    public void setOrderType(OrderType orderType) {
        this.orderType = orderType;
    }

    public LocalDate getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDate createAt) {
        this.createAt = createAt;
    }

    public LocalDate getDoneAt() {
        return doneAt;
    }

    public void setDoneAt(LocalDate doneAt) {
        this.doneAt = doneAt;
    }

    public ExchangeState getState() {
        return state;
    }

    public void setState(ExchangeState state) {
        this.state = state;
    }

    public Long getFeeId() {
        return feeId;
    }

    public void setFeeId(Long feeId) {
        this.feeId = feeId;
    }

    public Long getOrdererId() {
        return ordererId;
    }

    public void setOrdererId(Long memberId) {
        this.ordererId = memberId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ExchangeDTO exchangeDTO = (ExchangeDTO) o;
        if(exchangeDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), exchangeDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ExchangeDTO{" +
            "id=" + getId() +
            ", marketCurrency='" + getMarketCurrency() + "'" +
            ", baseCurrency='" + getBaseCurrency() + "'" +
            ", quantity=" + getQuantity() +
            ", rate=" + getRate() +
            ", orderType='" + getOrderType() + "'" +
            ", createAt='" + getCreateAt() + "'" +
            ", doneAt='" + getDoneAt() + "'" +
            ", state='" + getState() + "'" +
            "}";
    }
}
