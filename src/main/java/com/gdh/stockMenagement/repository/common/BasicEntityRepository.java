package com.gdh.stockMenagement.repository.common;

import com.gdh.stockMenagement.entity.common.BasicEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BasicEntityRepository<T extends BasicEntity, ID> extends JpaRepository<T, ID> {
}