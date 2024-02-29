package com.gdh.stockMenagement.repository.basic;

import com.gdh.stockMenagement.entity.User;
import com.gdh.stockMenagement.repository.common.BasicEntityRepository;
import com.gdh.stockMenagement.repository.queryDsl.UserQRepository;

import java.util.UUID;

public interface UserRepository extends BasicEntityRepository<User, UUID>, UserQRepository {
}