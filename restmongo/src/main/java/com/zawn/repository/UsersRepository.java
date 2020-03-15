package com.zawn.repository;

import java.math.BigInteger;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.zawn.domain.Users;

public interface UsersRepository extends MongoRepository<Users, BigInteger> {

}