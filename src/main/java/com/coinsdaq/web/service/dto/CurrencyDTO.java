package com.coinsdaq.web.service.dto;


import com.coinsdaq.web.domain.enumeration.CoinType;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * A DTO for the Currency entity.
 */
public class CurrencyDTO implements Serializable {

    private Long id;

    private String code;

    private String fullName;

    private Integer minConfirmation;

    private BigDecimal txFee;

    private Boolean isActive;

    private CoinType coinType;

    private String baseAddress;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getMinConfirmation() {
        return minConfirmation;
    }

    public void setMinConfirmation(Integer minConfirmation) {
        this.minConfirmation = minConfirmation;
    }

    public BigDecimal getTxFee() {
        return txFee;
    }

    public void setTxFee(BigDecimal txFee) {
        this.txFee = txFee;
    }

    public Boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public CoinType getCoinType() {
        return coinType;
    }

    public void setCoinType(CoinType coinType) {
        this.coinType = coinType;
    }

    public String getBaseAddress() {
        return baseAddress;
    }

    public void setBaseAddress(String baseAddress) {
        this.baseAddress = baseAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        CurrencyDTO currencyDTO = (CurrencyDTO) o;
        if(currencyDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), currencyDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "CurrencyDTO{" +
            "id=" + getId() +
            ", code='" + getCode() + "'" +
            ", fullName='" + getFullName() + "'" +
            ", minConfirmation=" + getMinConfirmation() +
            ", txFee=" + getTxFee() +
            ", isActive='" + isIsActive() + "'" +
            ", coinType='" + getCoinType() + "'" +
            ", baseAddress='" + getBaseAddress() + "'" +
            "}";
    }
}
