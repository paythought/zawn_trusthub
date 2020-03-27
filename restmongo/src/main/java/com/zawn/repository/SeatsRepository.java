package com.zawn.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.zawn.domain.Seats;
import com.zawn.domain.Users;

public interface SeatsRepository extends MongoRepository<Seats, String> {
	public List<Seats> findByIdcustomer(Users idcustomer); 
}