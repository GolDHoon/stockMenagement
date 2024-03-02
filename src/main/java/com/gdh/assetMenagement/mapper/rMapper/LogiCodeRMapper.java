package com.gdh.assetMenagement.mapper.rMapper;

import com.gdh.assetMenagement.dto.rDto.LogiCodeRDto;
import com.gdh.assetMenagement.entity.LogiCode;
import com.gdh.assetMenagement.mapper.rMapper.common.BasicEntityRMapper;

public class LogiCodeRMapper extends BasicEntityRMapper<LogiCode, LogiCodeRDto> {

    @Override
    protected LogiCode createEntityInstance() {
        return new LogiCode();
    }

    @Override
    protected LogiCodeRDto createDtoInstance() {
        return new LogiCodeRDto();
    }

    @Override
    public LogiCodeRDto toDto(LogiCode logiCode) {
        LogiCodeRDto logiCodeRDto = toDtoByBasic(logiCode);
        logiCodeRDto.setId(logiCode.getId());
        logiCodeRDto.setCode(logiCode.getCode());
        logiCodeRDto.setFullCode(logiCode.getFullCode());
        logiCodeRDto.setCodeValue(logiCode.getCodeValue());
        logiCodeRDto.setParentsCode(logiCode.getParentsCode());
        logiCodeRDto.setFullParentsCode(logiCode.getFullParentsCode());
        logiCodeRDto.setDiscription(logiCode.getDiscription());
        return logiCodeRDto;
    }

    @Override
    public LogiCode toEntity(LogiCodeRDto logiCodeRDto) {
        LogiCode logiCode = toEntityByBasic(logiCodeRDto);
        logiCode.setId(logiCodeRDto.getId());
        logiCode.setCode(logiCodeRDto.getCode());
        logiCode.setFullCode(logiCodeRDto.getFullCode());
        logiCode.setCodeValue(logiCodeRDto.getCodeValue());
        logiCode.setParentsCode(logiCodeRDto.getParentsCode());
        logiCode.setFullParentsCode(logiCodeRDto.getFullParentsCode());
        logiCode.setDiscription(logiCodeRDto.getDiscription());
        return logiCode;
    }
}
