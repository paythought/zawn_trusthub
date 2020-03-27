package com.zawn.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.zawn.domain.Notarizations;
import com.zawn.domain.Users;

public interface NotarizationsRepository extends MongoRepository<Notarizations, String> {
	public List<Notarizations> findByIdperson(Users idperson); 
}