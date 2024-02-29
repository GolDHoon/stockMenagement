package com.gdh.stockMenagement.repository.queryDsl;

import com.gdh.stockMenagement.entity.QUser;
import com.gdh.stockMenagement.entity.User;
import com.gdh.stockMenagement.repository.common.BasicQRepositoryImpl;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserQRepositoryImpl extends BasicQRepositoryImpl<User> implements UserQRepository{

    private final QUser qUser = QUser.user;  // Querydsl의 Q클래스를 사용

    @Autowired
    protected UserQRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        super(User.class, jpaQueryFactory);  // 상위 클래스로 Entity의 class 정보와 JPAQueryFactory를 전달
    }
}
