package com.gdh.stockMenagement.mapper.rMapper;

import com.gdh.stockMenagement.dto.rDto.CodeRRDto;
import com.gdh.stockMenagement.entity.Code;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface CodeRMapper {
    Code toEntity(CodeRRDto codeRRDto);

    CodeRRDto toDto(Code code);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Code partialUpdate(CodeRRDto codeRRDto, @MappingTarget Code code);
}