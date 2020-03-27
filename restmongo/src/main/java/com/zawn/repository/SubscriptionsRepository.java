package com.zawn.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.zawn.domain.Customers;
import com.zawn.domain.Subscriptions;

public interface SubscriptionsRepository extends MongoRepository<Subscriptions, String> {
	public List<Subscriptions> findByIdcustomer(Customers idcustomer); 
}