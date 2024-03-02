package com.gdh.assetMenagement.mapper.rMapper;

import com.gdh.assetMenagement.dto.rDto.UkcdCodeRDto;
import com.gdh.assetMenagement.entity.UkcdCode;
import com.gdh.assetMenagement.mapper.rMapper.common.BasicEntityRMapper;

public class UkcdCodeRMapper extends BasicEntityRMapper<UkcdCode, UkcdCodeRDto> {
    @Override
    protected UkcdCode createEntityInstance() {
        return new UkcdCode();
    }

    @Override
    protected UkcdCodeRDto createDtoInstance() {
        return new UkcdCodeRDto();
    }

    @Override
    public UkcdCodeRDto toDto(UkcdCode ukcdCode) {
        UkcdCodeRDto ukcdCodeRDto = toDtoByBasic(ukcdCode);
        ukcdCodeRDto.setId(ukcdCode.getId());
        ukcdCodeRDto.setCode(ukcdCode.getCode());
        ukcdCodeRDto.setFullCode(ukcdCode.getFullCode());
        ukcdCodeRDto.setCodeValue(ukcdCode.getCodeValue());
        ukcdCodeRDto.setParentsCode(ukcdCode.getParentsCode());
        ukcdCodeRDto.setFullParentsCode(ukcdCode.getFullParentsCode());
        ukcdCodeRDto.setDiscription(ukcdCode.getDiscription());
        return ukcdCodeRDto;
    }

    @Override
    public UkcdCode toEntity(UkcdCodeRDto ukcdCodeRDto) {
        UkcdCode ukcdCode = toEntityByBasic(ukcdCodeRDto);
        ukcdCode.setId(ukcdCodeRDto.getId());
        ukcdCode.setCode(ukcdCodeRDto.getCode());
        ukcdCode.setFullCode(ukcdCodeRDto.getFullCode());
        ukcdCode.setCodeValue(ukcdCodeRDto.getCodeValue());
        ukcdCode.setParentsCode(ukcdCodeRDto.getParentsCode());
        ukcdCode.setFullParentsCode(ukcdCodeRDto.getFullParentsCode());
        ukcdCode.setDiscription(ukcdCodeRDto.getDiscription());
        return ukcdCode;
    }
}
