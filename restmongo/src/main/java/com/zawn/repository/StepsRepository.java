package com.zawn.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.zawn.domain.Steps;
import com.zawn.domain.Users;

public interface StepsRepository extends MongoRepository<Steps, String> {
	public List<Steps> findByIdoperator(Users idoperator);
	public List<Steps> findByIdperson(Users idperson);
	public List<Steps> findByIdwitness(Users idwitness);
}