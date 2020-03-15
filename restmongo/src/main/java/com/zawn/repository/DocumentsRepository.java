package com.zawn.repository;

import java.math.BigInteger;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.zawn.domain.Documents;

public interface DocumentsRepository extends MongoRepository<Documents, BigInteger> {

}