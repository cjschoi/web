package com.coinsdaq.web.domain;

import com.coinsdaq.web.domain.enumeration.UserFeeState;
import com.coinsdaq.web.domain.enumeration.UserFeeType;
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
 * A UserFee.
 */
@Entity
@Table(name = "user_fee")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserFee implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "amount", precision=10, scale=2)
    private BigDecimal amount;

    @Column(name = "create_at")
    private LocalDate createAt;

    @Column(name = "done_at")
    private LocalDate doneAt;

    @Enumerated(EnumType.STRING)
    @Column(name = "state")
    private UserFeeState state;

    @Enumerated(EnumType.STRING)
    @Column(name = "jhi_type")
    private UserFeeType type;

    @OneToMany(mappedBy = "rule")
    @JsonIgnore
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Fee> fees = new HashSet<>();

    @ManyToOne
    private FeePolicy policy;

    @ManyToOne
    private User user;

}
