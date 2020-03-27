package com.zawn.repository;

import java.math.BigInteger;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.zawn.domain.Operations;

public interface OperationsRepository extends MongoRepository<Operations, String> {

}