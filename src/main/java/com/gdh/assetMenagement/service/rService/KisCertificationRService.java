package com.gdh.assetMenagement.service.rService;

import com.gdh.assetMenagement.dto.rDto.KisCertificationRDto;
import com.gdh.assetMenagement.entity.KisCertification;
import com.gdh.assetMenagement.mapper.rMapper.KisCertificationRMapper;
import com.gdh.assetMenagement.repository.basic.KisCertificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class KisCertificationRService {
    private KisCertificationRepository kisCertificationRepository;

    @Autowired
    public KisCertificationRService(KisCertificationRepository kisCertificationRepository) {
        this.kisCertificationRepository = kisCertificationRepository;
    }

    @Transactional(readOnly = true)
    public KisCertificationRDto selectKisCertificationFindByKisInfoId(UUID kisInfoId){
        KisCertificationRMapper kisCertificationRMapper = new KisCertificationRMapper();
        return kisCertificationRMapper.toDto(kisCertificationRepository.findByKisInfoIdx(kisInfoId).orElse(null));
    }

    @Transactional(readOnly = true)
    public List<KisCertificationRDto> selectKisCertificationFindAll() {
        List<KisCertificationRDto> kisCertificationRDtoList = new ArrayList<KisCertificationRDto>();
        KisCertificationRMapper kisCertificationRMapper = new KisCertificationRMapper();

        kisCertificationRepository.findAll().forEach(entity -> {
            kisCertificationRDtoList.add(kisCertificationRMapper.toDto(entity));
        });

        return kisCertificationRDtoList;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void saveKisCertification(KisCertificationRDto kisCertificationRDto){
        KisCertificationRMapper kisCertificationRMapper = new KisCertificationRMapper();
        KisCertification kisCertification = kisCertificationRMapper.toEntity(kisCertificationRDto);
        kisCertificationRepository.save(kisCertification);
    }
}
