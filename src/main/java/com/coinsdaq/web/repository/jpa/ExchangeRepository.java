package com.coinsdaq.web.repository.jpa;

import com.coinsdaq.web.domain.Exchange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Spring Data JPA repository for the Exchange entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ExchangeRepository extends JpaRepository<Exchange, Long> {

}
