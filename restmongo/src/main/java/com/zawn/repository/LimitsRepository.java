package com.zawn.repository;

import java.math.BigInteger;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.zawn.domain.Limits;

public interface LimitsRepository extends MongoRepository<Limits, BigInteger> {

}