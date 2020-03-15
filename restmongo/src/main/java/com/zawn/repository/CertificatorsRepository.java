package com.zawn.repository;

import java.math.BigInteger;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.zawn.domain.Certificators;

public interface CertificatorsRepository extends MongoRepository<Certificators, BigInteger> {

}