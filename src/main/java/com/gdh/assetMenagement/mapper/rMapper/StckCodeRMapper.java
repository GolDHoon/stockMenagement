package com.gdh.assetMenagement.mapper.rMapper;

import com.gdh.assetMenagement.dto.rDto.StckCodeRDto;
import com.gdh.assetMenagement.entity.StckCode;
import com.gdh.assetMenagement.mapper.rMapper.common.BasicEntityRMapper;

public class StckCodeRMapper extends BasicEntityRMapper<StckCode, StckCodeRDto> {
    @Override
    protected StckCode createEntityInstance() {
        return new StckCode();
    }

    @Override
    protected StckCodeRDto createDtoInstance() {
        return new StckCodeRDto();
    }

    @Override
    public StckCodeRDto toDto(StckCode stckCode) {
        StckCodeRDto stckCodeRDto = toDtoByBasic(stckCode);
        stckCodeRDto.setId(stckCode.getId());
        stckCodeRDto.setCode(stckCode.getCode());
        stckCodeRDto.setFullCode(stckCode.getFullCode());
        stckCodeRDto.setCodeValue(stckCode.getCodeValue());
        stckCodeRDto.setParentsCode(stckCode.getParentsCode());
        stckCodeRDto.setFullParentsCode(stckCode.getFullParentsCode());
        stckCodeRDto.setDiscription(stckCode.getDiscription());
        return stckCodeRDto;
    }

    @Override
    public StckCode toEntity(StckCodeRDto stckCodeRDto) {
        StckCode stckCode = toEntityByBasic(stckCodeRDto);
        stckCode.setId(stckCodeRDto.getId());
        stckCode.setCode(stckCodeRDto.getCode());
        stckCode.setFullCode(stckCodeRDto.getFullCode());
        stckCode.setCodeValue(stckCodeRDto.getCodeValue());
        stckCode.setParentsCode(stckCodeRDto.getParentsCode());
        stckCode.setFullParentsCode(stckCodeRDto.getFullParentsCode());
        stckCode.setDiscription(stckCodeRDto.getDiscription());
        return stckCode;
    }
}
