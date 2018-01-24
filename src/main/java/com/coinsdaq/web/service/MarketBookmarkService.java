package com.coinsdaq.web.service;

import com.coinsdaq.web.domain.MarketBookmark;
import com.coinsdaq.web.repository.jpa.MarketBookmarkRepository;
import com.coinsdaq.web.service.dto.MarketBookmarkDTO;
import com.coinsdaq.web.service.mapper.MarketBookmarkMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing MarketBookmark.
 */
@Service
@Transactional
public class MarketBookmarkService {

    private final Logger log = LoggerFactory.getLogger(MarketBookmarkService.class);

    private final MarketBookmarkRepository marketBookmarkRepository;

    private final MarketBookmarkMapper marketBookmarkMapper;

    public MarketBookmarkService(MarketBookmarkRepository marketBookmarkRepository, MarketBookmarkMapper marketBookmarkMapper) {
        this.marketBookmarkRepository = marketBookmarkRepository;
        this.marketBookmarkMapper = marketBookmarkMapper;
    }

    /**
     * Save a marketBookmark.
     *
     * @param marketBookmarkDTO the entity to save
     * @return the persisted entity
     */
    public MarketBookmarkDTO save(MarketBookmarkDTO marketBookmarkDTO) {
        log.debug("Request to save MarketBookmark : {}", marketBookmarkDTO);
        MarketBookmark marketBookmark = marketBookmarkMapper.toEntity(marketBookmarkDTO);
        marketBookmark = marketBookmarkRepository.save(marketBookmark);
        return marketBookmarkMapper.toDto(marketBookmark);
    }

    /**
     * Get all the marketBookmarks.
     *
     * @return the list of entities
     */
    @Transactional(readOnly = true)
    public List<MarketBookmarkDTO> findAll() {
        log.debug("Request to get all MarketBookmarks");
        return marketBookmarkRepository.findAll().stream()
            .map(marketBookmarkMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     * Get one marketBookmark by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Transactional(readOnly = true)
    public MarketBookmarkDTO findOne(Long id) {
        log.debug("Request to get MarketBookmark : {}", id);
        MarketBookmark marketBookmark = marketBookmarkRepository.getOne(id);
        return marketBookmarkMapper.toDto(marketBookmark);
    }

    /**
     * Delete the marketBookmark by id.
     *
     * @param id the id of the entity
     */
    public void delete(Long id) {
        log.debug("Request to delete MarketBookmark : {}", id);
        marketBookmarkRepository.deleteById(id);
    }
}
