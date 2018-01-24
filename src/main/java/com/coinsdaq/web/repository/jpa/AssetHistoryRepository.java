package com.coinsdaq.web.repository.jpa;

import com.coinsdaq.web.domain.AssetHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Spring Data JPA repository for the AssetHistory entity.
 */
@SuppressWarnings("unused")
@Repository
public interface AssetHistoryRepository extends JpaRepository<AssetHistory, Long> {

}
