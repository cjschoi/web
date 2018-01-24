package com.coinsdaq.web.service.mapper;

import com.coinsdaq.web.domain.OrderBook;
import com.coinsdaq.web.service.dto.OrderBookDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity OrderBook and its DTO OrderBookDTO.
 */
@Mapper(componentModel = "spring", uses = {MarketMapper.class})
public interface OrderBookMapper extends EntityMapper<OrderBookDTO, OrderBook> {

    @Mapping(source = "market.id", target = "marketId")
    OrderBookDTO toDto(OrderBook orderBook);

    @Mapping(source = "marketId", target = "market")
    OrderBook toEntity(OrderBookDTO orderBookDTO);

    default OrderBook fromId(Long id) {
        if (id == null) {
            return null;
        }
        OrderBook orderBook = new OrderBook();
        orderBook.setId(id);
        return orderBook;
    }
}
