package com.zawn.repository;

import java.math.BigInteger;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.zawn.domain.Parameters;

public interface ParametersRepository extends MongoRepository<Parameters, BigInteger> {

}