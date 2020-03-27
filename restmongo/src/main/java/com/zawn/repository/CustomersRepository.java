package com.zawn.repository;

import java.math.BigInteger;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.zawn.domain.Customers;

public interface CustomersRepository extends MongoRepository<Customers, String> {

}