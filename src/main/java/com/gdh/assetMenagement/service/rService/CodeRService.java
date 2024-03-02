package com.gdh.assetMenagement.service.rService;

import com.gdh.assetMenagement.dto.rDto.CodeRDto;
import com.gdh.assetMenagement.mapper.rMapper.CodeRMapper;
import com.gdh.assetMenagement.repository.basic.CodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CodeRService {
    private CodeRepository codeRepository;

    @Autowired
    public CodeRService(CodeRepository codeRepository) {
        this.codeRepository = codeRepository;
    }

    @Transactional(readOnly = true)
    public List<CodeRDto> selectCodeFindAll (){
        CodeRMapper codeRMapper = new CodeRMapper();
        List<CodeRDto> codeRDtoList = new ArrayList<CodeRDto>();

        codeRepository.findAll().forEach(entity -> {
            codeRDtoList.add(codeRMapper.toDto(entity));
        });

        return codeRDtoList;
    }
}
