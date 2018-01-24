package com.coinsdaq.web.service.dto;


import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the MarketBookmark entity.
 */
public class MarketBookmarkDTO implements Serializable {

    private Long id;

    private String name;

    private String baseCurrency;

    private Long userId;

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

    public String getBaseCurrency() {
        return baseCurrency;
    }

    public void setBaseCurrency(String baseCurrency) {
        this.baseCurrency = baseCurrency;
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

        MarketBookmarkDTO marketBookmarkDTO = (MarketBookmarkDTO) o;
        if(marketBookmarkDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), marketBookmarkDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "MarketBookmarkDTO{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", baseCurrency='" + getBaseCurrency() + "'" +
            "}";
    }
}
