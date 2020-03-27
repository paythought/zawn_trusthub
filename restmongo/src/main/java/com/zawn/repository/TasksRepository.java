package com.zawn.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.zawn.domain.Tasks;
import com.zawn.domain.Users;

public interface TasksRepository extends MongoRepository<Tasks, String> {
	public List<Tasks> findByIdowner(Users idowner);
	public List<Tasks> findByIdoperator(Users idoperator); 
	public List<Tasks> findByIdperson(Users idperson); 
}