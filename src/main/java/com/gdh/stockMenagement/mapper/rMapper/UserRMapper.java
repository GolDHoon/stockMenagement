package com.gdh.stockMenagement.mapper.rMapper;

import com.gdh.stockMenagement.dto.rDto.UserRDto;
import com.gdh.stockMenagement.entity.User;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UserRMapper {
    User toEntity(UserRDto userRDto);

    UserRDto toDto(User user);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    User partialUpdate(UserRDto userRDto, @MappingTarget User user);
}