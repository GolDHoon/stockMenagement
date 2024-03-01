package com.gdh.assetMenagement.repository.basic;

import com.gdh.assetMenagement.entity.User;
import com.gdh.assetMenagement.repository.common.BasicEntityRepository;
import com.gdh.assetMenagement.repository.queryDsl.UserQRepository;

import java.util.UUID;

public interface UserRepository extends BasicEntityRepository<User, UUID>, UserQRepository {
}