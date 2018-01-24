package com.coinsdaq.web.service.mapper;

import com.coinsdaq.web.domain.MarketBookmark;
import com.coinsdaq.web.service.dto.MarketBookmarkDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity MarketBookmark and its DTO MarketBookmarkDTO.
 */
@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface MarketBookmarkMapper extends EntityMapper<MarketBookmarkDTO, MarketBookmark> {

    @Mapping(source = "user.id", target = "userId")
    MarketBookmarkDTO toDto(MarketBookmark marketBookmark);

    @Mapping(target = "markets", ignore = true)
    @Mapping(source = "userId", target = "user")
    MarketBookmark toEntity(MarketBookmarkDTO marketBookmarkDTO);

    default MarketBookmark fromId(Long id) {
        if (id == null) {
            return null;
        }
        MarketBookmark marketBookmark = new MarketBookmark();
        marketBookmark.setId(id);
        return marketBookmark;
    }
}
