package com.coinsdaq.web.service.dto;


import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A DTO for the MarketSummary entity.
 */
public class MarketSummaryDTO implements Serializable {

    private Long id;

    private String marketName;

    private BigDecimal high;

    private BigDecimal low;

    private BigDecimal volume;

    private BigDecimal last;

    private BigDecimal baseVolume;

    private LocalDate timeStamp;

    private BigDecimal bid;

    private BigDecimal ask;

    private Integer term;

    private Integer openBuyOrders;

    private Integer openSellOrders;

    private BigDecimal prevDay;

    private LocalDate created;

    private String displayMarketName;

    private Long marketId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarketName() {
        return marketName;
    }

    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }

    public BigDecimal getHigh() {
        return high;
    }

    public void setHigh(BigDecimal high) {
        this.high = high;
    }

    public BigDecimal getLow() {
        return low;
    }

    public void setLow(BigDecimal low) {
        this.low = low;
    }

    public BigDecimal getVolume() {
        return volume;
    }

    public void setVolume(BigDecimal volume) {
        this.volume = volume;
    }

    public BigDecimal getLast() {
        return last;
    }

    public void setLast(BigDecimal last) {
        this.last = last;
    }

    public BigDecimal getBaseVolume() {
        return baseVolume;
    }

    public void setBaseVolume(BigDecimal baseVolume) {
        this.baseVolume = baseVolume;
    }

    public LocalDate getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDate timeStamp) {
        this.timeStamp = timeStamp;
    }

    public BigDecimal getBid() {
        return bid;
    }

    public void setBid(BigDecimal bid) {
        this.bid = bid;
    }

    public BigDecimal getAsk() {
        return ask;
    }

    public void setAsk(BigDecimal ask) {
        this.ask = ask;
    }

    public Integer getTerm() {
        return term;
    }

    public void setTerm(Integer term) {
        this.term = term;
    }

    public Integer getOpenBuyOrders() {
        return openBuyOrders;
    }

    public void setOpenBuyOrders(Integer openBuyOrders) {
        this.openBuyOrders = openBuyOrders;
    }

    public Integer getOpenSellOrders() {
        return openSellOrders;
    }

    public void setOpenSellOrders(Integer openSellOrders) {
        this.openSellOrders = openSellOrders;
    }

    public BigDecimal getPrevDay() {
        return prevDay;
    }

    public void setPrevDay(BigDecimal prevDay) {
        this.prevDay = prevDay;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public String getDisplayMarketName() {
        return displayMarketName;
    }

    public void setDisplayMarketName(String displayMarketName) {
        this.displayMarketName = displayMarketName;
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

        MarketSummaryDTO marketSummaryDTO = (MarketSummaryDTO) o;
        if(marketSummaryDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), marketSummaryDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "MarketSummaryDTO{" +
            "id=" + getId() +
            ", marketName='" + getMarketName() + "'" +
            ", high=" + getHigh() +
            ", low=" + getLow() +
            ", volume=" + getVolume() +
            ", last=" + getLast() +
            ", baseVolume=" + getBaseVolume() +
            ", timeStamp='" + getTimeStamp() + "'" +
            ", bid=" + getBid() +
            ", ask=" + getAsk() +
            ", term=" + getTerm() +
            ", openBuyOrders=" + getOpenBuyOrders() +
            ", openSellOrders=" + getOpenSellOrders() +
            ", prevDay=" + getPrevDay() +
            ", created='" + getCreated() + "'" +
            ", displayMarketName='" + getDisplayMarketName() + "'" +
            "}";
    }
}
