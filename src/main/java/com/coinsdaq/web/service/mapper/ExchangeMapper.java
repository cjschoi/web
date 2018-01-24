package com.coinsdaq.web.service.mapper;

import com.coinsdaq.web.domain.Exchange;
import com.coinsdaq.web.service.dto.ExchangeDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity Exchange and its DTO ExchangeDTO.
 */
@Mapper(componentModel = "spring", uses = {FeeMapper.class, UserMapper.class})
public interface ExchangeMapper extends EntityMapper<ExchangeDTO, Exchange> {

    @Mapping(source = "fee.id", target = "feeId")
    @Mapping(source = "orderer.id", target = "ordererId")
    ExchangeDTO toDto(Exchange exchange);

    @Mapping(source = "feeId", target = "fee")
    @Mapping(target = "assetHistories", ignore = true)
    @Mapping(source = "ordererId", target = "orderer")
    @Mapping(target = "orders", ignore = true)
    Exchange toEntity(ExchangeDTO exchangeDTO);

    default Exchange fromId(Long id) {
        if (id == null) {
            return null;
        }
        Exchange exchange = new Exchange();
        exchange.setId(id);
        return exchange;
    }
}
