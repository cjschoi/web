package com.coinsdaq.web.service.mapper;

import com.coinsdaq.web.domain.Fee;
import com.coinsdaq.web.service.dto.FeeDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity Fee and its DTO FeeDTO.
 */
@Mapper(componentModel = "spring", uses = {UserFeeMapper.class})
public interface FeeMapper extends EntityMapper<FeeDTO, Fee> {

    @Mapping(source = "rule.id", target = "ruleId")
    FeeDTO toDto(Fee fee);

    @Mapping(source = "ruleId", target = "rule")
    Fee toEntity(FeeDTO feeDTO);

    default Fee fromId(Long id) {
        if (id == null) {
            return null;
        }
        Fee fee = new Fee();
        fee.setId(id);
        return fee;
    }
}
