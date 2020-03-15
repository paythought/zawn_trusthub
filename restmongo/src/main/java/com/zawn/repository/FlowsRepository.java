package com.zawn.repository;

import java.math.BigInteger;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.zawn.domain.Flows;

public interface FlowsRepository extends MongoRepository<Flows, BigInteger> {

}