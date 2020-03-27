package com.zawn.repository;

import java.math.BigInteger;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.zawn.domain.Logs;
public interface LogsRepository extends MongoRepository<Logs, String> {

}