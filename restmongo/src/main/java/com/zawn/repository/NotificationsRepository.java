package com.zawn.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.zawn.domain.Notifications;
import com.zawn.domain.Users;

public interface NotificationsRepository extends MongoRepository<Notifications, String> {

 public List<Notifications> findByIdowner(Users idowner) ;
 public List<Notifications> findByIdperson(Users idperson) ;
	
}