package com.coinsdaq.web.domain;

import com.coinsdaq.web.domain.enumeration.FeePolicyState;
import com.coinsdaq.web.domain.enumeration.FeePolicyType;
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
 * A FeePolicy.
 */
@Entity
@Table(name = "fee_policy")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FeePolicy implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "amount", precision=10, scale=2)
    private BigDecimal amount;

    @Column(name = "create_at")
    private LocalDate createAt;

    @Column(name = "done_at")
    private LocalDate doneAt;

    @Enumerated(EnumType.STRING)
    @Column(name = "state")
    private FeePolicyState state;

    @Enumerated(EnumType.STRING)
    @Column(name = "jhi_type")
    private FeePolicyType type;

    @OneToMany(mappedBy = "policy")
    @JsonIgnore
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<UserFee> userFees = new HashSet<>();

}
