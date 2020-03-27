package com.zawn.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.BasePathAwareController;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zawn.domain.Users;
import com.zawn.dto.UserDTO;
import com.zawn.repository.UsersRepository;
import com.zawn.service.UserNotFoundException;
import com.zawn.service.UserRole;
import com.zawn.service.UserService;
/**
 * WebMvc Controller with Pure HATEOAP (not DATA REST)
 * @author home
 *
 */
@RepositoryRestController
@CrossOrigin()
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserModelAssembler userModelAssembler;
	@Autowired
	private UserService userDetailsService;
	
	private final UsersRepository usersRepository;
	
	@Autowired
	public UserController(UsersRepository usersRepository) {
		this.usersRepository=usersRepository;
	}
	
	//Aggregate root
	@GetMapping
	@ResponseBody 
	public CollectionModel<EntityModel<Users>> all() {
		List<EntityModel<Users>> users=
		usersRepository.findAll().stream().map(userModelAssembler::toModel).collect(Collectors.toList());
		
		return new CollectionModel<>(users, 
				linkTo(methodOn(UserController.class).all()).withSelfRel()
				) ;
	  }

	@GetMapping("/{id}")
	@ResponseBody 
	public EntityModel<Users> one(@PathVariable(required = true) final String id) {
		return userModelAssembler
				.toModel(usersRepository.findById(id).
						orElseThrow(() -> new UserNotFoundException(id.toString())));
	}
	
	@GetMapping("/me")
	@ResponseBody 
	public EntityModel<Users> findMe( ) {
		
		Authentication userAuthen=SecurityContextHolder.getContext().getAuthentication();
		if(userAuthen==null || !userAuthen.isAuthenticated() )
				throw new UserNotFoundException("Username not provided");
		String username=(userAuthen.getName());
		return userModelAssembler
				.toModel(usersRepository.findByUsername(username).
						orElseThrow(() -> new UserNotFoundException(username)));
	}
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	@ResponseBody 
	public ResponseEntity<?> insertUser(@RequestBody(required = true) UserDTO user) {
		EntityModel<Users> insertedUser = userModelAssembler.toModel(userDetailsService.insert(user));
		return ResponseEntity.created(insertedUser.getRequiredLink(IanaLinkRelations.SELF).toUri()).body(insertedUser);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseBody 
	public ResponseEntity<?> updateUser(@PathVariable(required=true) final String id ,
			@RequestBody(required=true) UserDTO user) {
		user.setId(id);
		EntityModel<Users> insertedUser=userModelAssembler.toModel(userDetailsService.update(user,false));
		return ResponseEntity.created(insertedUser.getRequiredLink(IanaLinkRelations.SELF).toUri())
				.body(insertedUser);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PATCH)
	@ResponseBody 
	public ResponseEntity<?> patchUser(@PathVariable(required=true) final String id ,
			@RequestBody(required=true) UserDTO user) {
		user.setId(id);
		EntityModel<Users> insertedUser=userModelAssembler.toModel(userDetailsService.update(user,true));
		return ResponseEntity.created(insertedUser.getRequiredLink(IanaLinkRelations.SELF).toUri())
				.body(insertedUser);
	}
	
	@RequestMapping(value = "/{id}/resetpassword", method = RequestMethod.PATCH)
	@ResponseBody 
	public ResponseEntity<?> resetUserPassword(
			@PathVariable(required=true) final String id,
			@RequestBody(required=true) UserDTO user) {
		user.setId(id);
		EntityModel<Users> insertedUser=userModelAssembler.toModel(userDetailsService.resetPassword(user));
		return ResponseEntity.created(insertedUser.getRequiredLink(IanaLinkRelations.SELF).toUri())
				.body(insertedUser);
	}
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody 
	public ResponseEntity<?> deleteUser(
			@PathVariable(required=true) final String id ) {
		UserDTO user=new UserDTO() ;
		user.setId(id);
		userDetailsService.delete(user);
		return ResponseEntity.noContent().build();
	}
	
}
