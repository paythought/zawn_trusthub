package com.zawn.repository;

import java.math.BigInteger;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.zawn.domain.Payments;

public interface PaymentsRepository extends MongoRepository<Payments, BigInteger> {

}