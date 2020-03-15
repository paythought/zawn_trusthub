package com.zawn.controller;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zawn.domain.Users;
import com.zawn.domain.authen.UserDTO;
import com.zawn.repository.UsersRepository;
import com.zawn.service.JwtUserDetailsService;
import com.zawn.service.UserNotFoundException;
import com.zawn.service.UserService;

@RestController
@CrossOrigin
public class UserController {

	@Autowired
	private UserService userDetailsService;
	@Autowired
	private UsersRepository usersRepository;
	@Autowired
	private UserModelAssembler userModelAssembler;
	
	//Aggregate root
	@GetMapping("/user")
	public CollectionModel<EntityModel<Users>> all() {
		List<EntityModel<Users>> users=
		usersRepository.findAll().stream().map(userModelAssembler::toModel).collect(Collectors.toList());
		
		return new CollectionModel<>(users, 
				linkTo(methodOn(UserController.class).all()).withSelfRel()
				) ;
	  }

	@GetMapping("/user/{id}")
	public EntityModel<Users> one(@PathVariable(required = true) final BigInteger id) {
		return userModelAssembler
				.toModel(usersRepository.findById(id).
						orElseThrow(() -> new UserNotFoundException(id.toString())));
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public ResponseEntity<?> insertUser(@RequestBody(required = true) UserDTO user) {
		EntityModel<Users> insertedUser = userModelAssembler.toModel(userDetailsService.insert(user));
		return ResponseEntity.created(insertedUser.getRequiredLink(IanaLinkRelations.SELF).toUri()).body(insertedUser);
	}

	@RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateUser(@PathVariable(required=true) final BigInteger id ,
			@RequestBody(required=true) UserDTO user) {
		user.setId(id);
		EntityModel<Users> insertedUser=userModelAssembler.toModel(userDetailsService.update(user));
		return ResponseEntity.created(insertedUser.getRequiredLink(IanaLinkRelations.SELF).toUri())
				.body(insertedUser);
	}
	
	@RequestMapping(value = "/user/{id}/resetpassword", method = RequestMethod.PATCH)
	public ResponseEntity<?> resetUserPassword(
			@PathVariable(required=true) final BigInteger id,
			@RequestBody(required=true) String password) {
		UserDTO user=new UserDTO();
		user.setId(id);
		user.setPassword(password);
		EntityModel<Users> insertedUser=userModelAssembler.toModel(userDetailsService.resetPassword(user));
		return ResponseEntity.created(insertedUser.getRequiredLink(IanaLinkRelations.SELF).toUri())
				.body(insertedUser);
		
	}
	
	
	@RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteUser(
			@PathVariable(required=true) final BigInteger id ) {
		UserDTO user=new UserDTO() ;
		user.setId(id);
		userDetailsService.delete(user);
		return ResponseEntity.noContent().build();
	}
	
}
