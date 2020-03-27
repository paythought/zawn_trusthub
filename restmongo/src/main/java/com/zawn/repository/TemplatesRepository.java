package com.zawn.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.zawn.domain.Templates;
import com.zawn.domain.Users;

public interface TemplatesRepository extends MongoRepository<Templates, String> {
	public List<Templates> findByIdperson(Users idperson); 
}