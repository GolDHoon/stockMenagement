package com.gdh.assetMenagement.repository.common;

import com.gdh.assetMenagement.entity.common.BasicEntity;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public abstract class BasicQRepositoryImpl<T extends BasicEntity> extends QuerydslRepositorySupport {
    private final JPAQueryFactory jpaQueryFactory;

    protected BasicQRepositoryImpl(Class<T> domainClass, JPAQueryFactory jpaQueryFactory) {
        super(domainClass);
        this.jpaQueryFactory = jpaQueryFactory;
    }

    protected JPAQueryFactory getJPAQueryFactory() {
        return jpaQueryFactory;
    }
}
