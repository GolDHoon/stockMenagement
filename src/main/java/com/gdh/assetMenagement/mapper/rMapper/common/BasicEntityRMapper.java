package com.gdh.assetMenagement.mapper.rMapper.common;

import com.gdh.assetMenagement.dto.common.BasicEntityRDto;
import com.gdh.assetMenagement.entity.common.BasicEntity;

public abstract class BasicEntityRMapper<E extends BasicEntity, D extends BasicEntityRDto>{

    public D toDtoByBasic(E entity){
        D dto = createDtoInstance();
        if(dto == null) dto = (D) new BasicEntityRDto();

        dto.setUse(entity.getUse());
        dto.setDel(entity.getDel());
        dto.setRegDate(entity.getRegDate());
        dto.setRegUser(entity.getRegUser());
        dto.setModDate(entity.getModDate());
        dto.setModUser(entity.getModUser());
        dto.setDelDate(entity.getDelDate());
        dto.setDelUser(entity.getDelUser());

        return dto;
    }

    public E toEntityByBasic(D dto){
        E entity = createEntityInstance();
        if(entity == null) entity = (E) new BasicEntity();

        entity.setUse(dto.getUse());
        entity.setDel(dto.getDel());
        entity.setRegDate(dto.getRegDate());
        entity.setRegUser(dto.getRegUser());
        entity.setModDate(dto.getModDate());
        entity.setModUser(dto.getModUser());
        entity.setDelDate(dto.getDelDate());
        entity.setDelUser(dto.getDelUser());

        return entity;
    }

    protected abstract E createEntityInstance();

    protected abstract D createDtoInstance();

    protected abstract D toDto(E entity);

    protected abstract E toEntity(D dto);
}
