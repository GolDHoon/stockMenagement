package com.gdh.assetMenagement.repository.basic;

import com.gdh.assetMenagement.entity.KisCertification;
import com.gdh.assetMenagement.repository.common.BasicEntityRepository;

import java.util.Optional;
import java.util.UUID;

public interface KisCertificationRepository extends BasicEntityRepository<KisCertification, UUID> {
    public Optional<KisCertification> findByKisInfoIdx(UUID kisInfoId);
}