package com.coinsdaq.web.service;

import com.coinsdaq.web.domain.MarketSummary;
import com.coinsdaq.web.repository.jpa.MarketSummaryRepository;
import com.coinsdaq.web.service.dto.MarketSummaryDTO;
import com.coinsdaq.web.service.mapper.MarketSummaryMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing MarketSummary.
 */
@Service
@Transactional
public class MarketSummaryService {

    private final Logger log = LoggerFactory.getLogger(MarketSummaryService.class);

    private final MarketSummaryRepository marketSummaryRepository;

    private final MarketSummaryMapper marketSummaryMapper;

    public MarketSummaryService(MarketSummaryRepository marketSummaryRepository, MarketSummaryMapper marketSummaryMapper) {
        this.marketSummaryRepository = marketSummaryRepository;
        this.marketSummaryMapper = marketSummaryMapper;
    }

    /**
     * Save a marketSummary.
     *
     * @param marketSummaryDTO the entity to save
     * @return the persisted entity
     */
    public MarketSummaryDTO save(MarketSummaryDTO marketSummaryDTO) {
        log.debug("Request to save MarketSummary : {}", marketSummaryDTO);
        MarketSummary marketSummary = marketSummaryMapper.toEntity(marketSummaryDTO);
        marketSummary = marketSummaryRepository.save(marketSummary);
        return marketSummaryMapper.toDto(marketSummary);
    }

    /**
     * Get all the marketSummaries.
     *
     * @return the list of entities
     */
    @Transactional(readOnly = true)
    public List<MarketSummaryDTO> findAll() {
        log.debug("Request to get all MarketSummaries");
        return marketSummaryRepository.findAll().stream()
            .map(marketSummaryMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     * Get one marketSummary by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Transactional(readOnly = true)
    public MarketSummaryDTO findOne(Long id) {
        log.debug("Request to get MarketSummary : {}", id);
        MarketSummary marketSummary = marketSummaryRepository.getOne(id);
        return marketSummaryMapper.toDto(marketSummary);
    }

    /**
     * Delete the marketSummary by id.
     *
     * @param id the id of the entity
     */
    public void delete(Long id) {
        log.debug("Request to delete MarketSummary : {}", id);
        marketSummaryRepository.deleteById(id);
    }
}
