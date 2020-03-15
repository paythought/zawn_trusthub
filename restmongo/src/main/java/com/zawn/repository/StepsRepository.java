package com.zawn.repository;

import java.math.BigInteger;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.zawn.domain.Steps;

public interface StepsRepository extends MongoRepository<Steps, BigInteger> {

}