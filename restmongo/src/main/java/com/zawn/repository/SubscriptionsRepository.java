package com.zawn.repository;

import java.math.BigInteger;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.zawn.domain.Subscriptions;

public interface SubscriptionsRepository extends MongoRepository<Subscriptions, BigInteger> {

}