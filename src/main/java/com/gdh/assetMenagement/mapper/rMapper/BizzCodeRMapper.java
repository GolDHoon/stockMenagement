package com.gdh.assetMenagement.mapper.rMapper;

import com.gdh.assetMenagement.dto.rDto.BizzCodeRDto;
import com.gdh.assetMenagement.entity.BizzCode;
import com.gdh.assetMenagement.mapper.rMapper.common.BasicEntityRMapper;

public class BizzCodeRMapper extends BasicEntityRMapper<BizzCode, BizzCodeRDto> {
    @Override
    protected BizzCode createEntityInstance() {
        return new BizzCode();
    }

    @Override
    protected BizzCodeRDto createDtoInstance() {
        return new BizzCodeRDto();
    }

    @Override
    public BizzCodeRDto toDto(BizzCode bizzCode) {
        BizzCodeRDto bizzCodeRDto = toDtoByBasic(bizzCode);
        bizzCodeRDto.setId(bizzCode.getId());
        bizzCodeRDto.setCode(bizzCode.getCode());
        bizzCodeRDto.setFullCode(bizzCode.getFullCode());
        bizzCodeRDto.setCodeValue(bizzCode.getCodeValue());
        bizzCodeRDto.setParentsCode(bizzCode.getParentsCode());
        bizzCodeRDto.setFullParentsCode(bizzCode.getFullParentsCode());
        bizzCodeRDto.setDiscription(bizzCode.getDiscription());
        return bizzCodeRDto;
    }

    @Override
    public BizzCode toEntity(BizzCodeRDto bizzCodeRDto) {
        BizzCode bizzCode = toEntityByBasic(bizzCodeRDto);
        bizzCode.setId(bizzCodeRDto.getId());
        bizzCode.setCode(bizzCodeRDto.getCode());
        bizzCode.setFullCode(bizzCodeRDto.getFullCode());
        bizzCode.setCodeValue(bizzCodeRDto.getCodeValue());
        bizzCode.setParentsCode(bizzCodeRDto.getParentsCode());
        bizzCode.setFullParentsCode(bizzCodeRDto.getFullParentsCode());
        bizzCode.setDiscription(bizzCodeRDto.getDiscription());
        return bizzCode;
    }
}
