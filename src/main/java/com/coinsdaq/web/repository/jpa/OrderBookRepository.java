package com.coinsdaq.web.repository.jpa;

import com.coinsdaq.web.domain.OrderBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Spring Data JPA repository for the OrderBook entity.
 */
@SuppressWarnings("unused")
@Repository
public interface OrderBookRepository extends JpaRepository<OrderBook, Long> {

}
