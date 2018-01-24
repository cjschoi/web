package com.coinsdaq.web.service;

import com.coinsdaq.web.domain.Market;
import com.coinsdaq.web.repository.jpa.MarketRepository;
import com.coinsdaq.web.service.dto.MarketDTO;
import com.coinsdaq.web.service.mapper.MarketMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing Market.
 */
@Service
@Transactional
public class MarketService {

    private final Logger log = LoggerFactory.getLogger(MarketService.class);

    private final MarketRepository marketRepository;

    private final MarketMapper marketMapper;

    public MarketService(MarketRepository marketRepository, MarketMapper marketMapper) {
        this.marketRepository = marketRepository;
        this.marketMapper = marketMapper;
    }

    /**
     * Save a market.
     *
     * @param marketDTO the entity to save
     * @return the persisted entity
     */
    public MarketDTO save(MarketDTO marketDTO) {
        log.debug("Request to save Market : {}", marketDTO);
        Market market = marketMapper.toEntity(marketDTO);
        market = marketRepository.save(market);
        return marketMapper.toDto(market);
    }

    /**
     * Get all the markets.
     *
     * @return the list of entities
     */
    @Transactional(readOnly = true)
    public List<MarketDTO> findAll() {
        log.debug("Request to get all Markets");
        return marketRepository.findAll().stream()
            .map(marketMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     * Get one market by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Transactional(readOnly = true)
    public MarketDTO findOne(Long id) {
        log.debug("Request to get Market : {}", id);
        Market market = marketRepository.getOne(id);
        return marketMapper.toDto(market);
    }

    /**
     * Delete the market by id.
     *
     * @param id the id of the entity
     */
    public void delete(Long id) {
        log.debug("Request to delete Market : {}", id);
        marketRepository.deleteById(id);
    }
}
