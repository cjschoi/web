package com.coinsdaq.web.service.mapper;

import com.coinsdaq.web.domain.Market;
import com.coinsdaq.web.service.dto.MarketDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity Market and its DTO MarketDTO.
 */
@Mapper(componentModel = "spring", uses = {MarketBookmarkMapper.class})
public interface MarketMapper extends EntityMapper<MarketDTO, Market> {

    @Mapping(source = "marketBookmark.id", target = "marketBookmarkId")
    MarketDTO toDto(Market market);

    @Mapping(target = "orders", ignore = true)
    @Mapping(target = "orderBooks", ignore = true)
    @Mapping(target = "marketSummaries", ignore = true)
    @Mapping(source = "marketBookmarkId", target = "marketBookmark")
    Market toEntity(MarketDTO marketDTO);

    default Market fromId(Long id) {
        if (id == null) {
            return null;
        }
        Market market = new Market();
        market.setId(id);
        return market;
    }
}
