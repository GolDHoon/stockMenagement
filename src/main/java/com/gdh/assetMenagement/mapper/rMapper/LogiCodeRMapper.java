package com.gdh.assetMenagement.mapper.rMapper;

import com.gdh.assetMenagement.dto.rDto.LogiCodeRRDto;
import com.gdh.assetMenagement.entity.LogiCode;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface LogiCodeRMapper {
    LogiCode toEntity(LogiCodeRRDto logiCodeRRDto);

    LogiCodeRRDto toDto(LogiCode logiCode);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    LogiCode partialUpdate(LogiCodeRRDto logiCodeRRDto, @MappingTarget LogiCode logiCode);
}