package com.gdh.assetMenagement.service.rService;

import com.gdh.assetMenagement.dto.rDto.BizzCodeRDto;
import com.gdh.assetMenagement.mapper.rMapper.BizzCodeRMapper;
import com.gdh.assetMenagement.repository.basic.BizzCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class BizzCodeRService {
    private BizzCodeRepository bizzCodeRepository;

    @Autowired
    public BizzCodeRService(BizzCodeRepository bizzCodeRepository) {
        this.bizzCodeRepository = bizzCodeRepository;
    }

    @Transactional(readOnly = true)
    public List<BizzCodeRDto> selectBizzCodeFindAll() {
        List<BizzCodeRDto> bizzCodeRDtoList = new ArrayList<BizzCodeRDto>();
        BizzCodeRMapper bizzCodeRMapper = new BizzCodeRMapper();

        bizzCodeRepository.findAll().forEach(entity -> {
            bizzCodeRDtoList.add(bizzCodeRMapper.toDto(entity));
        });

        return bizzCodeRDtoList;
    }
}
