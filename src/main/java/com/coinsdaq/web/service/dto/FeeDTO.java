package com.coinsdaq.web.service.dto;


import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A DTO for the Fee entity.
 */
public class FeeDTO implements Serializable {

    private Long id;

    private String currency;

    private BigDecimal amount;

    private LocalDate createAt;

    private LocalDate doneAt;

    private Long ruleId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
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

    public Long getRuleId() {
        return ruleId;
    }

    public void setRuleId(Long userFeeId) {
        this.ruleId = userFeeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        FeeDTO feeDTO = (FeeDTO) o;
        if(feeDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), feeDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "FeeDTO{" +
            "id=" + getId() +
            ", currency='" + getCurrency() + "'" +
            ", amount=" + getAmount() +
            ", createAt='" + getCreateAt() + "'" +
            ", doneAt='" + getDoneAt() + "'" +
            "}";
    }
}
