package com.coinsdaq.web.service;

import com.coinsdaq.web.domain.Orders;
import com.coinsdaq.web.repository.jpa.OrdersRepository;
import com.coinsdaq.web.service.dto.OrdersDTO;
import com.coinsdaq.web.service.mapper.OrdersMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Service Implementation for managing Orders.
 */
@Service
@Transactional
public class OrdersService {

    private final Logger log = LoggerFactory.getLogger(OrdersService.class);

    private final OrdersRepository ordersRepository;

    private final OrdersMapper ordersMapper;

    public OrdersService(OrdersRepository ordersRepository, OrdersMapper ordersMapper) {
        this.ordersRepository = ordersRepository;
        this.ordersMapper = ordersMapper;
    }

    /**
     * Save a orders.
     *
     * @param ordersDTO the entity to save
     * @return the persisted entity
     */
    public OrdersDTO save(OrdersDTO ordersDTO) {
        log.debug("Request to save Orders : {}", ordersDTO);
        Orders orders = ordersMapper.toEntity(ordersDTO);
        orders = ordersRepository.save(orders);
        return ordersMapper.toDto(orders);
    }

    /**
     * Get all the orders.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Transactional(readOnly = true)
    public Page<OrdersDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Orders");
        return ordersRepository.findAll(pageable)
            .map(ordersMapper::toDto);
    }


    /**
     *  get all the orders where Source is null.
     *  @return the list of entities
     */
    @Transactional(readOnly = true)
    public List<OrdersDTO> findAllWhereSourceIsNull() {
        log.debug("Request to get all orders where Source is null");
        return StreamSupport
            .stream(ordersRepository.findAll().spliterator(), false)
            .filter(orders -> orders.getSource() == null)
            .map(ordersMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     * Get one orders by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Transactional(readOnly = true)
    public OrdersDTO findOne(Long id) {
        log.debug("Request to get Orders : {}", id);
        Orders orders = ordersRepository.findOneWithEagerRelationships(id);
        return ordersMapper.toDto(orders);
    }

    /**
     * Delete the orders by id.
     *
     * @param id the id of the entity
     */
    public void delete(Long id) {
        log.debug("Request to delete Orders : {}", id);
        ordersRepository.deleteById(id);
    }
}
