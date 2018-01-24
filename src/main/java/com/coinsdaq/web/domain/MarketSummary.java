package com.coinsdaq.web.domain;

import lombok.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A MarketSummary.
 */
@Entity
@Table(name = "market_summary")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MarketSummary implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "market_name")
    private String marketName;

    @Column(name = "high", precision=10, scale=2)
    private BigDecimal high;

    @Column(name = "low", precision=10, scale=2)
    private BigDecimal low;

    @Column(name = "volume", precision=10, scale=2)
    private BigDecimal volume;

    @Column(name = "last", precision=10, scale=2)
    private BigDecimal last;

    @Column(name = "base_volume", precision=10, scale=2)
    private BigDecimal baseVolume;

    @Column(name = "time_stamp")
    private LocalDate timeStamp;

    @Column(name = "bid", precision=10, scale=2)
    private BigDecimal bid;

    @Column(name = "ask", precision=10, scale=2)
    private BigDecimal ask;

    @Column(name = "term")
    private Integer term;

    @Column(name = "open_buy_orders")
    private Integer openBuyOrders;

    @Column(name = "open_sell_orders")
    private Integer openSellOrders;

    @Column(name = "prev_day", precision=10, scale=2)
    private BigDecimal prevDay;

    @Column(name = "created")
    private LocalDate created;

    @Column(name = "display_market_name")
    private String displayMarketName;

    @ManyToOne
    private Market market;

}
