package com.zawn.repository;

import java.math.BigInteger;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.zawn.domain.Logs;

public interface LogsRepository extends MongoRepository<Logs, BigInteger> {

}