package com.zawn.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.zawn.domain.Parameters;
import com.zawn.domain.Users;

public interface ParametersRepository extends MongoRepository<Parameters, String> {
	public List<Parameters> findByIdcustomer(Users idcustomer); 
}