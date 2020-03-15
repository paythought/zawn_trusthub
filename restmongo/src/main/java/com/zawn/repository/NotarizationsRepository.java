package com.zawn.repository;

import java.math.BigInteger;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.zawn.domain.Notarizations;

public interface NotarizationsRepository extends MongoRepository<Notarizations, BigInteger> {

}