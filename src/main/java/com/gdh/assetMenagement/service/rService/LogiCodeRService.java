package com.gdh.assetMenagement.service.rService;

import com.gdh.assetMenagement.dto.rDto.LogiCodeRDto;
import com.gdh.assetMenagement.mapper.rMapper.LogiCodeRMapper;
import com.gdh.assetMenagement.repository.basic.LogiCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class LogiCodeRService {
    private LogiCodeRepository logiCodeRepository;

    @Autowired
    public LogiCodeRService(LogiCodeRepository logiCodeRepository) {
        this.logiCodeRepository = logiCodeRepository;
    }

    @Transactional(readOnly = true)
    public List<LogiCodeRDto> selectLogiCodeFindAll(){
        LogiCodeRMapper logiCodeRMapper = new LogiCodeRMapper();
        List<LogiCodeRDto> logiCodeRDtoList = new ArrayList<LogiCodeRDto>();

        logiCodeRepository.findAll().forEach(entity -> {
            logiCodeRDtoList.add(logiCodeRMapper.toDto(entity));
        });

        return logiCodeRDtoList;
    }
}
