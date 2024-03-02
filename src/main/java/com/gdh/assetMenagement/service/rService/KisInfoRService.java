package com.gdh.assetMenagement.service.rService;

import com.gdh.assetMenagement.dto.rDto.KisInfoRDto;
import com.gdh.assetMenagement.entity.KisInfo;
import com.gdh.assetMenagement.mapper.rMapper.KisInfoRMapper;
import com.gdh.assetMenagement.repository.basic.KisInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class KisInfoRService {
    private KisInfoRepository kisInfoRepository;
    @Autowired
    public KisInfoRService(KisInfoRepository kisInfoRepository) {
        this.kisInfoRepository = kisInfoRepository;
    }

    @Transactional(readOnly = true)
    public List<KisInfoRDto> selectKisInfoFindAll (){
        KisInfoRMapper kisInfoRMapper = new KisInfoRMapper();
        List<KisInfoRDto> kisInfoRDtoList = new ArrayList<KisInfoRDto>();

        kisInfoRepository.findAll().forEach(entity -> {
            kisInfoRDtoList.add(kisInfoRMapper.toDto(entity));
        });

        return kisInfoRDtoList;
    }
}
