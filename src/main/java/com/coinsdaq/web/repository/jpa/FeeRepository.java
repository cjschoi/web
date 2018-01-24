package com.coinsdaq.web.repository.jpa;

import com.coinsdaq.web.domain.Fee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Spring Data JPA repository for the Fee entity.
 */
@SuppressWarnings("unused")
@Repository
public interface FeeRepository extends JpaRepository<Fee, Long> {

}
