package com.gdh.assetMenagement.mapper.rMapper;

import com.gdh.assetMenagement.dto.rDto.StckCodeRDto;
import com.gdh.assetMenagement.entity.StckCode;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface StckCodeRMapper {
    StckCode toEntity(StckCodeRDto stckCodeRDto);

    StckCodeRDto toDto(StckCode stckCode);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    StckCode partialUpdate(StckCodeRDto stckCodeRDto, @MappingTarget StckCode stckCode);
}