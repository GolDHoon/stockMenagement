package com.gdh.assetMenagement.service.rService;

import com.gdh.assetMenagement.dto.rDto.UkcdCodeRDto;
import com.gdh.assetMenagement.mapper.rMapper.UkcdCodeRMapper;
import com.gdh.assetMenagement.repository.basic.UkcdCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UkcdCodeRService {
    private UkcdCodeRepository ukcdCodeRepository;

    @Autowired
    public UkcdCodeRService(UkcdCodeRepository ukcdCodeRepository) {
        this.ukcdCodeRepository = ukcdCodeRepository;
    }

    @Transactional(readOnly = true)
    public List<UkcdCodeRDto> selectUkcdCodeFindAll(){
        UkcdCodeRMapper ukcdCodeRMapper = new UkcdCodeRMapper();
        List<UkcdCodeRDto> ukcdCodeRDtoList = new ArrayList<UkcdCodeRDto>();

        ukcdCodeRepository.findAll().forEach(entity -> {
            ukcdCodeRDtoList.add(ukcdCodeRMapper.toDto(entity));
        });

        return ukcdCodeRDtoList;
    }
}
