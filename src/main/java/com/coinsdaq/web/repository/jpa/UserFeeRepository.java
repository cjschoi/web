package com.coinsdaq.web.repository.jpa;

import com.coinsdaq.web.domain.UserFee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Spring Data JPA repository for the UserFee entity.
 */
@SuppressWarnings("unused")
@Repository
public interface UserFeeRepository extends JpaRepository<UserFee, Long> {

}
