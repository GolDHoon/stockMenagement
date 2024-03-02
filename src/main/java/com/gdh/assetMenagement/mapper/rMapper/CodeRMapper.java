package com.gdh.assetMenagement.mapper.rMapper;

import com.gdh.assetMenagement.dto.rDto.CodeRDto;
import com.gdh.assetMenagement.entity.Code;
import com.gdh.assetMenagement.mapper.rMapper.common.BasicEntityRMapper;

public class CodeRMapper extends BasicEntityRMapper<Code, CodeRDto> {

    @Override
    protected Code createEntityInstance() {
        return new Code();
    }

    @Override
    protected CodeRDto createDtoInstance() {
        return new CodeRDto();
    }

    @Override
    public CodeRDto toDto(Code code) {
        CodeRDto codeRDto = toDtoByBasic(code);
        codeRDto.setId(code.getId());
        codeRDto.setCode(code.getCode());
        codeRDto.setCodeValue(code.getCodeValue());
        codeRDto.setDiscription(code.getDiscription());

        return codeRDto;
    }

    @Override
    public Code toEntity(CodeRDto codeRDto) {
        Code code = toEntityByBasic(codeRDto);
        code.setId(codeRDto.getId());
        code.setCode(codeRDto.getCode());
        code.setCodeValue(codeRDto.getCodeValue());
        code.setDiscription(codeRDto.getDiscription());
        return code;
    }
}
