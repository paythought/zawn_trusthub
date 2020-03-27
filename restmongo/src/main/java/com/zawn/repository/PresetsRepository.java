package com.zawn.repository;

import java.math.BigInteger;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.zawn.domain.Presets;

public interface PresetsRepository extends MongoRepository<Presets, String> {

}