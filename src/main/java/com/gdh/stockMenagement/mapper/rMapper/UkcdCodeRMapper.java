package com.gdh.stockMenagement.mapper.rMapper;

import com.gdh.stockMenagement.dto.rDto.UkcdCodeRRDto;
import com.gdh.stockMenagement.entity.UkcdCode;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UkcdCodeRMapper {
    UkcdCode toEntity(UkcdCodeRRDto ukcdCodeRRDto);

    UkcdCodeRRDto toDto(UkcdCode ukcdCode);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    UkcdCode partialUpdate(UkcdCodeRRDto ukcdCodeRRDto, @MappingTarget UkcdCode ukcdCode);
}