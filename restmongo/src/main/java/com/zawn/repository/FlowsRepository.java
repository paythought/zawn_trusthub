package com.zawn.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.zawn.domain.Flows;
import com.zawn.domain.Users;

public interface FlowsRepository extends MongoRepository<Flows, String> {
	public List<Flows> findByIdperson(Users idperson); 
}