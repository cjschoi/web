package com.coinsdaq.web.service;

import com.coinsdaq.web.domain.Exchange;
import com.coinsdaq.web.repository.jpa.ExchangeRepository;
import com.coinsdaq.web.service.dto.ExchangeDTO;
import com.coinsdaq.web.service.dto.TradingInfoDTO;
import com.coinsdaq.web.service.mapper.ExchangeMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing Exchange.
 */
@Service("exchangeService")
@Transactional
public class ExchangeService {

    private final Logger log = LoggerFactory.getLogger(ExchangeService.class);

    private final ExchangeRepository exchangeRepository;

    private final ExchangeMapper exchangeMapper;

    public ExchangeService(ExchangeRepository exchangeRepository, ExchangeMapper exchangeMapper) {
        this.exchangeRepository = exchangeRepository;
        this.exchangeMapper = exchangeMapper;
    }

    /**
     * Save a exchange.
     *
     * @param exchangeDTO the entity to save
     * @return the persisted entity
     */
    public ExchangeDTO save(ExchangeDTO exchangeDTO) {
        log.debug("Request to save Exchange : {}", exchangeDTO);
        Exchange exchange = exchangeMapper.toEntity(exchangeDTO);
        exchange = exchangeRepository.save(exchange);
        return exchangeMapper.toDto(exchange);
    }

    /**
     * Get all the exchanges.
     *
     * @return the list of entities
     */
    @Transactional(readOnly = true)
    public List<ExchangeDTO> findAll() {
        log.debug("Request to get all Exchanges");
        return exchangeRepository.findAll().stream()
            .map(exchangeMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     * Get one exchange by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Transactional(readOnly = true)
    public ExchangeDTO findOne(Long id) {
        log.debug("Request to get Exchange : {}", id);
        Exchange exchange = exchangeRepository.getOne(id);
        return exchangeMapper.toDto(exchange);
    }

    /**
     * Delete the exchange by id.
     *
     * @param id the id of the entity
     */
    public void delete(Long id) {
        log.debug("Request to delete Exchange : {}", id);
        exchangeRepository.deleteById(id);
    }

    public TradingInfoDTO getTradingInfo() {

        TradingInfoDTO tradingInfoDTO = new TradingInfoDTO();
        tradingInfoDTO.setBase_volume("32,668.608");
        tradingInfoDTO.setBaseCurrency("KRW");
        tradingInfoDTO.setHigh("15,198,000");
        tradingInfoDTO.setLast("14,860,000");
        tradingInfoDTO.setLow("14,352,000");
        tradingInfoDTO.setMarketCurrency("BTC");
        tradingInfoDTO.setMarketName("비트코인");
        tradingInfoDTO.setVolume("482,117,295,407");



        return tradingInfoDTO;
    }
}
