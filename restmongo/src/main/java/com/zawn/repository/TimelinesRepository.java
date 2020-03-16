package com.zawn.repository;

import java.math.BigInteger;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.zawn.domain.Timelines;

public interface TimelinesRepository extends MongoRepository<Timelines, BigInteger> {

}