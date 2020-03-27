package com.zawn.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.zawn.domain.Timelines;
import com.zawn.domain.Users;

public interface TimelinesRepository extends MongoRepository<Timelines, String> {
	public List<Timelines> findByIdowner(Users idowner); 
}