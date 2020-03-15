package com.zawn.repository;

import java.math.BigInteger;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.zawn.domain.Templates;

public interface TemplatesRepository extends MongoRepository<Templates, BigInteger> {

}