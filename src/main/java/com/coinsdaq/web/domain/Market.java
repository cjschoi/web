package com.coinsdaq.web.domain;

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
 * A Market.
 */
@Entity
@Table(name = "market")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Market implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "exchange_name")
    private String exchangeName;

    @Column(name = "market_currency")
    private String marketCurrency;

    @Column(name = "base_currency")
    private String baseCurrency;

    @Column(name = "market_currency_long")
    private String marketCurrencyLong;

    @Column(name = "base_currency_long")
    private String baseCurrencyLong;

    @Column(name = "min_trade_size", precision=10, scale=2)
    private BigDecimal minTradeSize;

    @Column(name = "market_name")
    private String marketName;

    @Column(name = "is_active")
    private Boolean isActive;

    @OneToMany(mappedBy = "market")
    @JsonIgnore
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Orders> orders = new HashSet<>();

    @OneToMany(mappedBy = "market")
    @JsonIgnore
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<OrderBook> orderBooks = new HashSet<>();

    @OneToMany(mappedBy = "market")
    @JsonIgnore
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<MarketSummary> marketSummaries = new HashSet<>();

    @ManyToOne
    private MarketBookmark marketBookmark;

}
