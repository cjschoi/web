package com.coinsdaq.web.service.mapper;

import com.coinsdaq.web.domain.FeePolicy;
import com.coinsdaq.web.service.dto.FeePolicyDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity FeePolicy and its DTO FeePolicyDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface FeePolicyMapper extends EntityMapper<FeePolicyDTO, FeePolicy> {

    

    @Mapping(target = "userFees", ignore = true)
    FeePolicy toEntity(FeePolicyDTO feePolicyDTO);

    default FeePolicy fromId(Long id) {
        if (id == null) {
            return null;
        }
        FeePolicy feePolicy = new FeePolicy();
        feePolicy.setId(id);
        return feePolicy;
    }
}
