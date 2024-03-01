package com.gdh.assetMenagement.repository.basic;

import com.gdh.assetMenagement.entity.StckCode;
import com.gdh.assetMenagement.repository.common.BasicEntityRepository;
import org.springframework.data.repository.history.RevisionRepository;

import java.util.UUID;

public interface StckCodeRepository extends BasicEntityRepository<StckCode, UUID> {
}