package com.coinsdaq.web.service;

import com.coinsdaq.web.domain.FeePolicy;
import com.coinsdaq.web.repository.jpa.FeePolicyRepository;
import com.coinsdaq.web.service.dto.FeePolicyDTO;
import com.coinsdaq.web.service.mapper.FeePolicyMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing FeePolicy.
 */
@Service
@Transactional
public class FeePolicyService {

    private final Logger log = LoggerFactory.getLogger(FeePolicyService.class);

    private final FeePolicyRepository feePolicyRepository;

    private final FeePolicyMapper feePolicyMapper;

    public FeePolicyService(FeePolicyRepository feePolicyRepository, FeePolicyMapper feePolicyMapper) {
        this.feePolicyRepository = feePolicyRepository;
        this.feePolicyMapper = feePolicyMapper;
    }

    /**
     * Save a feePolicy.
     *
     * @param feePolicyDTO the entity to save
     * @return the persisted entity
     */
    public FeePolicyDTO save(FeePolicyDTO feePolicyDTO) {
        log.debug("Request to save FeePolicy : {}", feePolicyDTO);
        FeePolicy feePolicy = feePolicyMapper.toEntity(feePolicyDTO);
        feePolicy = feePolicyRepository.save(feePolicy);
        return feePolicyMapper.toDto(feePolicy);
    }

    /**
     * Get all the feePolicies.
     *
     * @return the list of entities
     */
    @Transactional(readOnly = true)
    public List<FeePolicyDTO> findAll() {
        log.debug("Request to get all FeePolicies");
        return feePolicyRepository.findAll().stream()
            .map(feePolicyMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     * Get one feePolicy by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Transactional(readOnly = true)
    public FeePolicyDTO findOne(Long id) {
        log.debug("Request to get FeePolicy : {}", id);
        FeePolicy feePolicy = feePolicyRepository.getOne(id);
        return feePolicyMapper.toDto(feePolicy);
    }

    /**
     * Delete the feePolicy by id.
     *
     * @param id the id of the entity
     */
    public void delete(Long id) {
        log.debug("Request to delete FeePolicy : {}", id);
        feePolicyRepository.deleteById(id);
    }
}
