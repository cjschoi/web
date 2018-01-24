package com.coinsdaq.web.repository.jpa;

import com.coinsdaq.web.domain.MarketSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Spring Data JPA repository for the MarketSummary entity.
 */
@SuppressWarnings("unused")
@Repository
public interface MarketSummaryRepository extends JpaRepository<MarketSummary, Long> {

}
