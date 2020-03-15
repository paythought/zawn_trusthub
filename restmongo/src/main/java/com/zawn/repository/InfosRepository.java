package com.zawn.repository;

import java.math.BigInteger;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.zawn.domain.Infos;

public interface InfosRepository extends MongoRepository<Infos, BigInteger> {

}