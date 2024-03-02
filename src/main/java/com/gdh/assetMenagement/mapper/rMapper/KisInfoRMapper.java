package com.gdh.assetMenagement.mapper.rMapper;

import com.gdh.assetMenagement.dto.rDto.KisInfoRDto;
import com.gdh.assetMenagement.entity.KisInfo;
import com.gdh.assetMenagement.mapper.rMapper.common.BasicEntityRMapper;

public class KisInfoRMapper extends BasicEntityRMapper<KisInfo, KisInfoRDto> {

    @Override
    protected KisInfo createEntityInstance() {
        return new KisInfo();
    }

    @Override
    protected KisInfoRDto createDtoInstance() {
        return new KisInfoRDto();
    }

    @Override
    public KisInfoRDto toDto(KisInfo kisInfo){
        KisInfoRDto kisInfoRDto = toDtoByBasic(kisInfo);
        kisInfoRDto.setId(kisInfo.getId());
        kisInfoRDto.setKisCode(kisInfo.getKisCode());
        kisInfoRDto.setUserIdx(kisInfo.getUserIdx());

        return kisInfoRDto;
    }

    @Override
    public KisInfo toEntity(KisInfoRDto kisInfoRDto) {
        KisInfo kisInfo = toEntityByBasic(kisInfoRDto);
        kisInfo.setId(kisInfoRDto.getId());
        kisInfo.setKisCode(kisInfoRDto.getKisCode());
        kisInfo.setUserIdx(kisInfoRDto.getUserIdx());
        return kisInfo;
    }
}
