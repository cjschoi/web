package com.coinsdaq.web.service.dto;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * A DTO for the Market entity.
 */
public class MarketDTO implements Serializable {

    private Long id;

    private String exchangeName;

    private String marketCurrency;

    private String baseCurrency;

    private String marketCurrencyLong;

    private String baseCurrencyLong;

    private BigDecimal minTradeSize;

    private String marketName;

    private Boolean isActive;

    private Long marketBookmarkId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getExchangeName() {
        return exchangeName;
    }

    public void setExchangeName(String exchangeName) {
        this.exchangeName = exchangeName;
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

    public String getMarketCurrencyLong() {
        return marketCurrencyLong;
    }

    public void setMarketCurrencyLong(String marketCurrencyLong) {
        this.marketCurrencyLong = marketCurrencyLong;
    }

    public String getBaseCurrencyLong() {
        return baseCurrencyLong;
    }

    public void setBaseCurrencyLong(String baseCurrencyLong) {
        this.baseCurrencyLong = baseCurrencyLong;
    }

    public BigDecimal getMinTradeSize() {
        return minTradeSize;
    }

    public void setMinTradeSize(BigDecimal minTradeSize) {
        this.minTradeSize = minTradeSize;
    }

    public String getMarketName() {
        return marketName;
    }

    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }

    public Boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Long getMarketBookmarkId() {
        return marketBookmarkId;
    }

    public void setMarketBookmarkId(Long marketBookmarkId) {
        this.marketBookmarkId = marketBookmarkId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MarketDTO marketDTO = (MarketDTO) o;
        if(marketDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), marketDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "MarketDTO{" +
            "id=" + getId() +
            ", exchangeName='" + getExchangeName() + "'" +
            ", marketCurrency='" + getMarketCurrency() + "'" +
            ", baseCurrency='" + getBaseCurrency() + "'" +
            ", marketCurrencyLong='" + getMarketCurrencyLong() + "'" +
            ", baseCurrencyLong='" + getBaseCurrencyLong() + "'" +
            ", minTradeSize=" + getMinTradeSize() +
            ", marketName='" + getMarketName() + "'" +
            ", isActive='" + isIsActive() + "'" +
            "}";
    }
}
