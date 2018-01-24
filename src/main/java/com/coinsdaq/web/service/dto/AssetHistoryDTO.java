package com.coinsdaq.web.service.dto;


import com.coinsdaq.web.domain.enumeration.AccountHistoryState;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A DTO for the AssetHistory entity.
 */
public class AssetHistoryDTO implements Serializable {

    private Long id;

    private BigDecimal amount;

    private LocalDate createAt;

    private LocalDate doneAt;

    private AccountHistoryState state;

    private Long assetId;

    private Long exchangeId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
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

    public AccountHistoryState getState() {
        return state;
    }

    public void setState(AccountHistoryState state) {
        this.state = state;
    }

    public Long getAssetId() {
        return assetId;
    }

    public void setAssetId(Long assetId) {
        this.assetId = assetId;
    }

    public Long getExchangeId() {
        return exchangeId;
    }

    public void setExchangeId(Long exchangeId) {
        this.exchangeId = exchangeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        AssetHistoryDTO assetHistoryDTO = (AssetHistoryDTO) o;
        if(assetHistoryDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), assetHistoryDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "AssetHistoryDTO{" +
            "id=" + getId() +
            ", amount=" + getAmount() +
            ", createAt='" + getCreateAt() + "'" +
            ", doneAt='" + getDoneAt() + "'" +
            ", state='" + getState() + "'" +
            "}";
    }
}
