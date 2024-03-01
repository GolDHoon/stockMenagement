package com.gdh.assetMenagement.mapper.rMapper;

import com.gdh.assetMenagement.dto.rDto.BizzCodeRDto;
import com.gdh.assetMenagement.entity.BizzCode;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface BizzCodeRMapper {
    BizzCode toEntity(BizzCodeRDto bizzCodeRDto);

    BizzCodeRDto toDto(BizzCode bizzCode);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    BizzCode partialUpdate(BizzCodeRDto bizzCodeRDto, @MappingTarget BizzCode bizzCode);
}