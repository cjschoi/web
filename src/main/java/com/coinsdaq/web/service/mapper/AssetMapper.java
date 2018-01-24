package com.coinsdaq.web.service.mapper;

import com.coinsdaq.web.domain.Asset;
import com.coinsdaq.web.service.dto.AssetDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity Asset and its DTO AssetDTO.
 */
@Mapper(componentModel = "spring", uses = {OrdersMapper.class, UserMapper.class})
public interface AssetMapper extends EntityMapper<AssetDTO, Asset> {

    @Mapping(source = "order.id", target = "orderId")
    @Mapping(source = "owner.id", target = "ownerId")
    AssetDTO toDto(Asset asset);

    @Mapping(source = "orderId", target = "order")
    @Mapping(target = "histories", ignore = true)
    @Mapping(source = "ownerId", target = "owner")
    Asset toEntity(AssetDTO assetDTO);

    default Asset fromId(Long id) {
        if (id == null) {
            return null;
        }
        Asset asset = new Asset();
        asset.setId(id);
        return asset;
    }
}
