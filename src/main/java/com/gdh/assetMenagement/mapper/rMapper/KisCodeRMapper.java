package com.gdh.assetMenagement.mapper.rMapper;

import com.gdh.assetMenagement.dto.rDto.KisCodeRDto;
import com.gdh.assetMenagement.entity.KisCode;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface KisCodeRMapper {
    KisCode toEntity(KisCodeRDto kisCodeRDto);

    KisCodeRDto toDto(KisCode kisCode);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    KisCode partialUpdate(KisCodeRDto kisCodeRDto, @MappingTarget KisCode kisCode);
}