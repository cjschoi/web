package com.coinsdaq.web.service;

import com.coinsdaq.web.domain.UserFee;
import com.coinsdaq.web.repository.jpa.UserFeeRepository;
import com.coinsdaq.web.service.dto.UserFeeDTO;
import com.coinsdaq.web.service.mapper.UserFeeMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing UserFee.
 */
@Service
@Transactional
public class UserFeeService {

    private final Logger log = LoggerFactory.getLogger(UserFeeService.class);

    private final UserFeeRepository userFeeRepository;

    private final UserFeeMapper userFeeMapper;

    public UserFeeService(UserFeeRepository userFeeRepository, UserFeeMapper userFeeMapper) {
        this.userFeeRepository = userFeeRepository;
        this.userFeeMapper = userFeeMapper;
    }

    /**
     * Save a userFee.
     *
     * @param userFeeDTO the entity to save
     * @return the persisted entity
     */
    public UserFeeDTO save(UserFeeDTO userFeeDTO) {
        log.debug("Request to save UserFee : {}", userFeeDTO);
        UserFee userFee = userFeeMapper.toEntity(userFeeDTO);
        userFee = userFeeRepository.save(userFee);
        return userFeeMapper.toDto(userFee);
    }

    /**
     * Get all the userFees.
     *
     * @return the list of entities
     */
    @Transactional(readOnly = true)
    public List<UserFeeDTO> findAll() {
        log.debug("Request to get all UserFees");
        return userFeeRepository.findAll().stream()
            .map(userFeeMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     * Get one userFee by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Transactional(readOnly = true)
    public UserFeeDTO findOne(Long id) {
        log.debug("Request to get UserFee : {}", id);
        UserFee userFee = userFeeRepository.getOne(id);
        return userFeeMapper.toDto(userFee);
    }

    /**
     * Delete the userFee by id.
     *
     * @param id the id of the entity
     */
    public void delete(Long id) {
        log.debug("Request to delete UserFee : {}", id);
        userFeeRepository.deleteById(id);
    }
}
