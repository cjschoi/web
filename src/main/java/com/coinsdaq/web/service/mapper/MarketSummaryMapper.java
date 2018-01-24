package com.coinsdaq.web.service.mapper;

import com.coinsdaq.web.domain.MarketSummary;
import com.coinsdaq.web.service.dto.MarketSummaryDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity MarketSummary and its DTO MarketSummaryDTO.
 */
@Mapper(componentModel = "spring", uses = {MarketMapper.class})
public interface MarketSummaryMapper extends EntityMapper<MarketSummaryDTO, MarketSummary> {

    @Mapping(source = "market.id", target = "marketId")
    MarketSummaryDTO toDto(MarketSummary marketSummary);

    @Mapping(source = "marketId", target = "market")
    MarketSummary toEntity(MarketSummaryDTO marketSummaryDTO);

    default MarketSummary fromId(Long id) {
        if (id == null) {
            return null;
        }
        MarketSummary marketSummary = new MarketSummary();
        marketSummary.setId(id);
        return marketSummary;
    }
}
