package com.coinsdaq.web.domain;

import com.coinsdaq.web.domain.enumeration.AssetState;
import com.coinsdaq.web.domain.enumeration.AssetType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * A Asset.
 */
@Entity
@Table(name = "asset")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Asset implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "currency")
    private String currency;

    @Column(name = "amount", precision=10, scale=2)
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    @Column(name = "state")
    private AssetState state;

    @Enumerated(EnumType.STRING)
    @Column(name = "jhi_type")
    private AssetType type;

    @Column(name = "jhi_locked")
    private Boolean locked;

    @OneToOne
    @JoinColumn(unique = true)
    private Orders order;

    @OneToMany(mappedBy = "asset")
    @JsonIgnore
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<AssetHistory> histories = new HashSet<>();

    @ManyToOne
    private User owner;

}
