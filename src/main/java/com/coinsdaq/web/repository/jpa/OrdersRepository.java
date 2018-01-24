package com.coinsdaq.web.repository.jpa;

import com.coinsdaq.web.domain.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Spring Data JPA repository for the Orders entity.
 */
@SuppressWarnings("unused")
@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long> {
    @Query("select distinct orders from Orders orders left join fetch orders.exchanges")
    List<Orders> findAllWithEagerRelationships();

    @Query("select orders from Orders orders left join fetch orders.exchanges where orders.id =:id")
    Orders findOneWithEagerRelationships(@Param("id") Long id);

}
