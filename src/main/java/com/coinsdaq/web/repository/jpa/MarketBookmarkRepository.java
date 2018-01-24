package com.coinsdaq.web.repository.jpa;

import com.coinsdaq.web.domain.MarketBookmark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Spring Data JPA repository for the MarketBookmark entity.
 */
@SuppressWarnings("unused")
@Repository
public interface MarketBookmarkRepository extends JpaRepository<MarketBookmark, Long> {

}
