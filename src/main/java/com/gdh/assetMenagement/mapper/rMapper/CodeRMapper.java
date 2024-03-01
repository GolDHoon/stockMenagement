package com.gdh.assetMenagement.mapper.rMapper;

import com.gdh.assetMenagement.dto.rDto.CodeRDto;
import com.gdh.assetMenagement.entity.Code;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface CodeRMapper {
    Code toEntity(CodeRDto codeRDto);

    CodeRDto toDto(Code code);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Code partialUpdate(CodeRDto codeRDto, @MappingTarget Code code);
}