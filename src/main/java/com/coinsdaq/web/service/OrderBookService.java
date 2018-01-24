package com.coinsdaq.web.service;

import com.coinsdaq.web.domain.OrderBook;
import com.coinsdaq.web.repository.jpa.OrderBookRepository;
import com.coinsdaq.web.service.dto.OrderBookDTO;
import com.coinsdaq.web.service.mapper.OrderBookMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing OrderBook.
 */
@Service
@Transactional
public class OrderBookService {

    private final Logger log = LoggerFactory.getLogger(OrderBookService.class);

    private final OrderBookRepository orderBookRepository;

    private final OrderBookMapper orderBookMapper;

    public OrderBookService(OrderBookRepository orderBookRepository, OrderBookMapper orderBookMapper) {
        this.orderBookRepository = orderBookRepository;
        this.orderBookMapper = orderBookMapper;
    }

    /**
     * Save a orderBook.
     *
     * @param orderBookDTO the entity to save
     * @return the persisted entity
     */
    public OrderBookDTO save(OrderBookDTO orderBookDTO) {
        log.debug("Request to save OrderBook : {}", orderBookDTO);
        OrderBook orderBook = orderBookMapper.toEntity(orderBookDTO);
        orderBook = orderBookRepository.save(orderBook);
        return orderBookMapper.toDto(orderBook);
    }

    /**
     * Get all the orderBooks.
     *
     * @return the list of entities
     */
    @Transactional(readOnly = true)
    public List<OrderBookDTO> findAll() {
        log.debug("Request to get all OrderBooks");
        return orderBookRepository.findAll().stream()
            .map(orderBookMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     * Get one orderBook by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Transactional(readOnly = true)
    public OrderBookDTO findOne(Long id) {
        log.debug("Request to get OrderBook : {}", id);
        OrderBook orderBook = orderBookRepository.getOne(id);
        return orderBookMapper.toDto(orderBook);
    }

    /**
     * Delete the orderBook by id.
     *
     * @param id the id of the entity
     */
    public void delete(Long id) {
        log.debug("Request to delete OrderBook : {}", id);
        orderBookRepository.deleteById(id);
    }
}
