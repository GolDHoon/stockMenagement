package com.gdh.assetMenagement.repository.common;

import com.gdh.assetMenagement.entity.common.BasicEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BasicEntityRepository<T extends BasicEntity, ID> extends JpaRepository<T, ID> {
}