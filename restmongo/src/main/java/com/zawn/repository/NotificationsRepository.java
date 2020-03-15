package com.zawn.repository;

import java.math.BigInteger;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.zawn.domain.Notifications;

public interface NotificationsRepository extends MongoRepository<Notifications, BigInteger> {

}