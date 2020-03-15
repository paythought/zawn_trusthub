package com.zawn.repository;

import java.math.BigInteger;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.zawn.domain.Tasks;

public interface TasksRepository extends MongoRepository<Tasks, BigInteger> {

}