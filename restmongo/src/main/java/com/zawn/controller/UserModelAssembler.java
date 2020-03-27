package com.zawn.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import com.zawn.domain.Users;

@Component
public class UserModelAssembler implements RepresentationModelAssembler<Users, EntityModel<Users>> {

	@Override
	public EntityModel<Users> toModel(Users user) {

		EntityModel<Users> model = new EntityModel<>(user,
				linkTo(methodOn(UserController.class).one(user.getId())).withSelfRel()
				//TODO Not generated links in JSON
				.andAffordance(afford(methodOn(UserController.class).insertUser(null)))
				.andAffordance(afford(methodOn(UserController.class).updateUser(user.getId(), null)))
				.andAffordance(afford(methodOn(UserController.class).deleteUser(user.getId())))
				
				,linkTo(methodOn(UserController.class).all()).withRel("user"));
		// Add a link resetPassword
//		model.add(
//				linkTo(methodOn(UserController.class).resetUserPassword(user.getId(), null)).withRel("resetPassword"));
		return model;
	}

}