package com.zawn.repository;

import java.math.BigInteger;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.zawn.domain.Devices;

public interface DevicesRepository extends MongoRepository<Devices, BigInteger> {

}