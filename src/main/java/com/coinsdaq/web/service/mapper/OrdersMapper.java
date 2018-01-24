package com.coinsdaq.web.service.mapper;

import com.coinsdaq.web.domain.Orders;
import com.coinsdaq.web.service.dto.OrdersDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity Orders and its DTO OrdersDTO.
 */
@Mapper(componentModel = "spring", uses = {ExchangeMapper.class, MarketMapper.class, UserMapper.class})
public interface OrdersMapper extends EntityMapper<OrdersDTO, Orders> {

    @Mapping(source = "market.id", target = "marketId")
    @Mapping(source = "user.id", target = "userId")
    OrdersDTO toDto(Orders orders);

    @Mapping(target = "source", ignore = true)
    @Mapping(source = "marketId", target = "market")
    @Mapping(source = "userId", target = "user")
    Orders toEntity(OrdersDTO ordersDTO);

    default Orders fromId(Long id) {
        if (id == null) {
            return null;
        }
        Orders orders = new Orders();
        orders.setId(id);
        return orders;
    }
}
