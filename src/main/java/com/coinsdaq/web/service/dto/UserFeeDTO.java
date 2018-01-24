package com.coinsdaq.web.service.dto;


import com.coinsdaq.web.domain.enumeration.UserFeeState;
import com.coinsdaq.web.domain.enumeration.UserFeeType;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A DTO for the UserFee entity.
 */
public class UserFeeDTO implements Serializable {

    private Long id;

    private BigDecimal amount;

    private LocalDate createAt;

    private LocalDate doneAt;

    private UserFeeState state;

    private UserFeeType type;

    private Long policyId;

    private Long userId;

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

    public UserFeeState getState() {
        return state;
    }

    public void setState(UserFeeState state) {
        this.state = state;
    }

    public UserFeeType getType() {
        return type;
    }

    public void setType(UserFeeType type) {
        this.type = type;
    }

    public Long getPolicyId() {
        return policyId;
    }

    public void setPolicyId(Long feePolicyId) {
        this.policyId = feePolicyId;
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

        UserFeeDTO userFeeDTO = (UserFeeDTO) o;
        if(userFeeDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), userFeeDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "UserFeeDTO{" +
            "id=" + getId() +
            ", amount=" + getAmount() +
            ", createAt='" + getCreateAt() + "'" +
            ", doneAt='" + getDoneAt() + "'" +
            ", state='" + getState() + "'" +
            ", type='" + getType() + "'" +
            "}";
    }
}
