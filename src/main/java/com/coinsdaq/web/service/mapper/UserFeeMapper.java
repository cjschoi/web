package com.coinsdaq.web.service.mapper;

import com.coinsdaq.web.domain.UserFee;
import com.coinsdaq.web.service.dto.UserFeeDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity UserFee and its DTO UserFeeDTO.
 */
@Mapper(componentModel = "spring", uses = {FeePolicyMapper.class, UserMapper.class})
public interface UserFeeMapper extends EntityMapper<UserFeeDTO, UserFee> {

    @Mapping(source = "policy.id", target = "policyId")
    @Mapping(source = "user.id", target = "userId")
    UserFeeDTO toDto(UserFee userFee);

    @Mapping(target = "fees", ignore = true)
    @Mapping(source = "policyId", target = "policy")
    @Mapping(source = "userId", target = "user")
    UserFee toEntity(UserFeeDTO userFeeDTO);

    default UserFee fromId(Long id) {
        if (id == null) {
            return null;
        }
        UserFee userFee = new UserFee();
        userFee.setId(id);
        return userFee;
    }
}
