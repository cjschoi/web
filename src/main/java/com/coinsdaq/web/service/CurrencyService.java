package com.coinsdaq.web.service;

import com.coinsdaq.web.domain.Currency;
import com.coinsdaq.web.repository.jpa.CurrencyRepository;
import com.coinsdaq.web.service.dto.CurrencyDTO;
import com.coinsdaq.web.service.mapper.CurrencyMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing Currency.
 */
@Service
@Transactional
public class CurrencyService {

    private final Logger log = LoggerFactory.getLogger(CurrencyService.class);

    private final CurrencyRepository currencyRepository;

    private final CurrencyMapper currencyMapper;

    public CurrencyService(CurrencyRepository currencyRepository, CurrencyMapper currencyMapper) {
        this.currencyRepository = currencyRepository;
        this.currencyMapper = currencyMapper;
    }

    /**
     * Save a currency.
     *
     * @param currencyDTO the entity to save
     * @return the persisted entity
     */
    public CurrencyDTO save(CurrencyDTO currencyDTO) {
        log.debug("Request to save Currency : {}", currencyDTO);
        Currency currency = currencyMapper.toEntity(currencyDTO);
        currency = currencyRepository.save(currency);
        return currencyMapper.toDto(currency);
    }

    /**
     * Get all the currencies.
     *
     * @return the list of entities
     */
    @Transactional(readOnly = true)
    public List<CurrencyDTO> findAll() {
        log.debug("Request to get all Currencies");
        return currencyRepository.findAll().stream()
            .map(currencyMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     * Get one currency by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Transactional(readOnly = true)
    public CurrencyDTO findOne(Long id) {
        log.debug("Request to get Currency : {}", id);
        Currency currency = currencyRepository.getOne(id);
        return currencyMapper.toDto(currency);
    }

    /**
     * Delete the currency by id.
     *
     * @param id the id of the entity
     */
    public void delete(Long id) {
        log.debug("Request to delete Currency : {}", id);
        currencyRepository.deleteById(id);
    }
}
