package com.zawn.repository;

import java.math.BigInteger;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.zawn.domain.Licences;

public interface LicensesRepository extends MongoRepository<Licences, String> {

}