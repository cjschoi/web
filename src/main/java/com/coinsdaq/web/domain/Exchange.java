package com.coinsdaq.web.domain;

import com.coinsdaq.web.domain.enumeration.ExchangeState;
import com.coinsdaq.web.domain.enumeration.OrderType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * A Exchange.
 */
@Entity
@Table(name = "exchange")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Exchange implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "market_currency")
    private String marketCurrency;

    @Column(name = "base_currency")
    private String baseCurrency;

    @Column(name = "quantity", precision=10, scale=2)
    private BigDecimal quantity;

    @Column(name = "rate", precision=10, scale=2)
    private BigDecimal rate;

    @Enumerated(EnumType.STRING)
    @Column(name = "order_type")
    private OrderType orderType;

    @Column(name = "create_at")
    private LocalDate createAt;

    @Column(name = "done_at")
    private LocalDate doneAt;

    @Enumerated(EnumType.STRING)
    @Column(name = "state")
    private ExchangeState state;

    @OneToOne
    @JoinColumn(unique = true)
    private Fee fee;

    @OneToMany(mappedBy = "exchange")
    @JsonIgnore
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<AssetHistory> assetHistories = new HashSet<>();

    @ManyToOne
    private User orderer;

    @ManyToMany(mappedBy = "exchanges")
    @JsonIgnore
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Orders> orders = new HashSet<>();

}
