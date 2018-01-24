package com.coinsdaq.web.domain;

import com.coinsdaq.web.domain.enumeration.OrderCondition;
import com.coinsdaq.web.domain.enumeration.OrderState;
import com.coinsdaq.web.domain.enumeration.OrderStrategy;
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
 * A Orders.
 */
@Entity
@Table(name = "orders")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Orders implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "quantity", precision=10, scale=2)
    private BigDecimal quantity;

    @Column(name = "quantity_remaining", precision=10, scale=2)
    private BigDecimal quantityRemaining;

    @Column(name = "rate", precision=10, scale=2)
    private BigDecimal rate;

    @Enumerated(EnumType.STRING)
    @Column(name = "state")
    private OrderState state;

    @Enumerated(EnumType.STRING)
    @Column(name = "jhi_type")
    private OrderType type;

    @Enumerated(EnumType.STRING)
    @Column(name = "strategy")
    private OrderStrategy strategy;

    @Enumerated(EnumType.STRING)
    @Column(name = "jhi_condition")
    private OrderCondition condition;

    @Column(name = "market_currency")
    private String marketCurrency;

    @Column(name = "base_currency")
    private String baseCurrency;

    @Column(name = "create_at")
    private LocalDate createAt;

    @Column(name = "updated_at")
    private LocalDate updatedAt;

    @Column(name = "done_at")
    private LocalDate doneAt;

    @Column(name = "jhi_locked")
    private Boolean locked;

    @ManyToMany
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @JoinTable(name = "orders_exchanges",
               joinColumns = @JoinColumn(name="orders_id", referencedColumnName="id"),
               inverseJoinColumns = @JoinColumn(name="exchanges_id", referencedColumnName="id"))
    private Set<Exchange> exchanges = new HashSet<>();

    @OneToOne(mappedBy = "order")
    @JsonIgnore
    private Asset source;

    @ManyToOne
    private Market market;

    @ManyToOne
    private User user;

}
