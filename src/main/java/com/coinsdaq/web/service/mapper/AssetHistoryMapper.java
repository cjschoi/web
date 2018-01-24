package com.coinsdaq.web.service.mapper;

import com.coinsdaq.web.domain.AssetHistory;
import com.coinsdaq.web.service.dto.AssetHistoryDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity AssetHistory and its DTO AssetHistoryDTO.
 */
@Mapper(componentModel = "spring", uses = {AssetMapper.class, ExchangeMapper.class})
public interface AssetHistoryMapper extends EntityMapper<AssetHistoryDTO, AssetHistory> {

    @Mapping(source = "asset.id", target = "assetId")
    @Mapping(source = "exchange.id", target = "exchangeId")
    AssetHistoryDTO toDto(AssetHistory assetHistory);

    @Mapping(source = "assetId", target = "asset")
    @Mapping(source = "exchangeId", target = "exchange")
    AssetHistory toEntity(AssetHistoryDTO assetHistoryDTO);

    default AssetHistory fromId(Long id) {
        if (id == null) {
            return null;
        }
        AssetHistory assetHistory = new AssetHistory();
        assetHistory.setId(id);
        return assetHistory;
    }
}
