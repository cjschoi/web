package com.coinsdaq.web.service.dto;


import com.coinsdaq.web.domain.enumeration.FeePolicyState;
import com.coinsdaq.web.domain.enumeration.FeePolicyType;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A DTO for the FeePolicy entity.
 */
public class FeePolicyDTO implements Serializable {

    private Long id;

    private String name;

    private BigDecimal amount;

    private LocalDate createAt;

    private LocalDate doneAt;

    private FeePolicyState state;

    private FeePolicyType type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public FeePolicyState getState() {
        return state;
    }

    public void setState(FeePolicyState state) {
        this.state = state;
    }

    public FeePolicyType getType() {
        return type;
    }

    public void setType(FeePolicyType type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        FeePolicyDTO feePolicyDTO = (FeePolicyDTO) o;
        if(feePolicyDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), feePolicyDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "FeePolicyDTO{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", amount=" + getAmount() +
            ", createAt='" + getCreateAt() + "'" +
            ", doneAt='" + getDoneAt() + "'" +
            ", state='" + getState() + "'" +
            ", type='" + getType() + "'" +
            "}";
    }
}
