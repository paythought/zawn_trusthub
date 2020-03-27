package com.zawn.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.zawn.domain.Infos;
import com.zawn.domain.Users;

public interface InfosRepository extends MongoRepository<Infos, String> {
	public List<Infos> findByIdperson(Users idperson); 
}