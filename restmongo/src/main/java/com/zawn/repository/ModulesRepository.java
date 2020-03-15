package com.zawn.repository;

import java.math.BigInteger;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.zawn.domain.Modules;

public interface ModulesRepository extends MongoRepository<Modules, BigInteger> {

}