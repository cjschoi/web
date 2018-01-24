package com.coinsdaq.web.service;

import com.coinsdaq.web.domain.Fee;
import com.coinsdaq.web.repository.jpa.FeeRepository;
import com.coinsdaq.web.service.dto.FeeDTO;
import com.coinsdaq.web.service.mapper.FeeMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing Fee.
 */
@Service
@Transactional
public class FeeService {

    private final Logger log = LoggerFactory.getLogger(FeeService.class);

    private final FeeRepository feeRepository;

    private final FeeMapper feeMapper;

    public FeeService(FeeRepository feeRepository, FeeMapper feeMapper) {
        this.feeRepository = feeRepository;
        this.feeMapper = feeMapper;
    }

    /**
     * Save a fee.
     *
     * @param feeDTO the entity to save
     * @return the persisted entity
     */
    public FeeDTO save(FeeDTO feeDTO) {
        log.debug("Request to save Fee : {}", feeDTO);
        Fee fee = feeMapper.toEntity(feeDTO);
        fee = feeRepository.save(fee);
        return feeMapper.toDto(fee);
    }

    /**
     * Get all the fees.
     *
     * @return the list of entities
     */
    @Transactional(readOnly = true)
    public List<FeeDTO> findAll() {
        log.debug("Request to get all Fees");
        return feeRepository.findAll().stream()
            .map(feeMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     * Get one fee by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Transactional(readOnly = true)
    public FeeDTO findOne(Long id) {
        log.debug("Request to get Fee : {}", id);
        Fee fee = feeRepository.getOne(id);
        return feeMapper.toDto(fee);
    }

    /**
     * Delete the fee by id.
     *
     * @param id the id of the entity
     */
    public void delete(Long id) {
        log.debug("Request to delete Fee : {}", id);
        feeRepository.deleteById(id);
    }
}
