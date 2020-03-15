package com.zawn.repository;

import java.math.BigInteger;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.zawn.domain.Status;

public interface StatusRepository extends MongoRepository<Status, BigInteger> {

}