package com.zawn.repository;

import java.math.BigInteger;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.zawn.domain.Wallets;

public interface WalletsRepository extends MongoRepository<Wallets, BigInteger> {

}