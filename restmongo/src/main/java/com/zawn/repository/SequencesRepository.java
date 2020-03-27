package com.zawn.repository;

import java.math.BigInteger;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.zawn.domain.Sequences;

public interface SequencesRepository extends MongoRepository<Sequences, String> {

}