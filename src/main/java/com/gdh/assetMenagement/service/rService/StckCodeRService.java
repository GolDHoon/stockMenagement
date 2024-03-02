package com.gdh.assetMenagement.service.rService;

import com.gdh.assetMenagement.dto.rDto.StckCodeRDto;
import com.gdh.assetMenagement.mapper.rMapper.StckCodeRMapper;
import com.gdh.assetMenagement.repository.basic.StckCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class StckCodeRService {
    private StckCodeRepository stckCodeRepository;

    @Autowired
    public StckCodeRService(StckCodeRepository stckCodeRepository) {
        this.stckCodeRepository = stckCodeRepository;
    }

    @Transactional(readOnly = true)
    public List<StckCodeRDto> selectStckCodeFindAll(){
        List<StckCodeRDto> stckCodeRDtoList = new ArrayList<StckCodeRDto>();
        StckCodeRMapper stckCodRMapper = new StckCodeRMapper();

        stckCodeRepository.findAll().forEach(entity -> {
            stckCodeRDtoList.add(stckCodRMapper.toDto(entity));
        });

        return stckCodeRDtoList;
    }
}
