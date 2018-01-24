package com.coinsdaq.web.repository.jpa;

import com.coinsdaq.web.domain.FeePolicy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Spring Data JPA repository for the FeePolicy entity.
 */
@SuppressWarnings("unused")
@Repository
public interface FeePolicyRepository extends JpaRepository<FeePolicy, Long> {

}
