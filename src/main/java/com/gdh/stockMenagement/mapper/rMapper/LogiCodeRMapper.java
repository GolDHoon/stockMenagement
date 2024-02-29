package com.gdh.stockMenagement.mapper.rMapper;

import com.gdh.stockMenagement.dto.rDto.LogiCodeRRDto;
import com.gdh.stockMenagement.entity.LogiCode;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface LogiCodeRMapper {
    LogiCode toEntity(LogiCodeRRDto logiCodeRRDto);

    LogiCodeRRDto toDto(LogiCode logiCode);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    LogiCode partialUpdate(LogiCodeRRDto logiCodeRRDto, @MappingTarget LogiCode logiCode);
}