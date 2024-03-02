package com.gdh.assetMenagement.mapper.rMapper;

import com.gdh.assetMenagement.dto.rDto.KisCertificationRDto;
import com.gdh.assetMenagement.entity.KisCertification;
import com.gdh.assetMenagement.mapper.rMapper.common.BasicEntityRMapper;

public class KisCertificationRMapper extends BasicEntityRMapper<KisCertification, KisCertificationRDto> {
    @Override
    protected KisCertification createEntityInstance() {
        return null;
    }

    @Override
    protected KisCertificationRDto createDtoInstance() {
        return null;
    }

    @Override
    public KisCertificationRDto toDto(KisCertification kisCertification) {
        KisCertificationRDto kisCertificationRDto = toDtoByBasic(kisCertification);
        kisCertificationRDto.setId(kisCertification.getId());
        kisCertificationRDto.setKisInfoIdx(kisCertification.getKisInfoIdx());
        kisCertificationRDto.setAppKey(kisCertification.getAppKey());
        kisCertificationRDto.setAppSecret(kisCertification.getAppSecret());
        kisCertificationRDto.setApprovalKey(kisCertification.getApprovalKey());
        kisCertificationRDto.setAccessToken(kisCertification.getAccessToken());
        kisCertificationRDto.setTokenType(kisCertification.getTokenType());
        kisCertificationRDto.setAccessTokenExpired(kisCertification.getAccessTokenExpired());
        return kisCertificationRDto;
    }

    @Override
    public KisCertification toEntity(KisCertificationRDto kisCertificationRDto) {
        KisCertification kisCertification = toEntityByBasic(kisCertificationRDto);
        kisCertification.setId(kisCertificationRDto.getId());
        kisCertification.setKisInfoIdx(kisCertificationRDto.getKisInfoIdx());
        kisCertification.setAppKey(kisCertificationRDto.getAppKey());
        kisCertification.setAppSecret(kisCertificationRDto.getAppSecret());
        kisCertification.setApprovalKey(kisCertificationRDto.getApprovalKey());
        kisCertification.setAccessToken(kisCertificationRDto.getAccessToken());
        kisCertification.setTokenType(kisCertificationRDto.getTokenType());
        kisCertification.setAccessTokenExpired(kisCertificationRDto.getAccessTokenExpired());
        return kisCertification;
    }
}
