package com.zawn.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.zawn.domain.Documents;
import com.zawn.domain.Users;

public interface DocumentsRepository extends MongoRepository<Documents, String> {
	public List<Documents> findByIduser(Users iduser); 
}