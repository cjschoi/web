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
 * A Fee.
 */
@Entity
@Table(name = "fee")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Fee implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "currency")
    private String currency;

    @Column(name = "amount", precision=10, scale=2)
    private BigDecimal amount;

    @Column(name = "create_at")
    private LocalDate createAt;

    @Column(name = "done_at")
    private LocalDate doneAt;

    @ManyToOne
    private UserFee rule;

}
