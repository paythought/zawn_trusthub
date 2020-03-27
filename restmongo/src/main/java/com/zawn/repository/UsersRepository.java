package com.zawn.repository;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.zawn.domain.Users;
import com.zawn.domain.preview.UsersPreview;
import com.zawn.repository.repofrag.UsersRepoFragment;
//@RepositoryRestResource(excerptProjection = UsersPreview.class)
public interface UsersRepository extends MongoRepository<Users, String>, UsersRepoFragment {//,QuerydslPredicateExecutor<Users>
 Optional<Users> findByUsername(String username);
}