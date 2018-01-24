package com.coinsdaq.web.domain;

import com.coinsdaq.web.domain.enumeration.OrderType;
import lombok.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * A OrderBook.
 */
@Entity
@Table(name = "order_book")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderBook implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "jhi_type")
    private OrderType type;

    @Column(name = "quantity", precision=10, scale=2)
    private BigDecimal quantity;

    @Column(name = "rate", precision=10, scale=2)
    private BigDecimal rate;

    @ManyToOne
    private Market market;

}
