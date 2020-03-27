package com.zawn.repository;

import java.math.BigInteger;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.zawn.domain.Settings;

public interface SettingsRepository extends MongoRepository<Settings, String> {

}