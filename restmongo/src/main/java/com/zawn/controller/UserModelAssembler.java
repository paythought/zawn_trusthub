package com.zawn.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import com.zawn.domain.Users;
import com.zawn.domain.authen.UserDTO;

@Component
public class UserModelAssembler implements RepresentationModelAssembler<Users, EntityModel<Users>> {

	@Override
	public EntityModel<Users> toModel(Users user) {

		EntityModel<Users> model = new EntityModel<>(user,
				linkTo(methodOn(UserController.class).deleteUser(user.getId())).withSelfRel(),
				linkTo(methodOn(UserController.class).all()).withRel("user"));
		// Add a link resetPassword
		model.add(
				linkTo(methodOn(UserController.class).resetUserPassword(user.getId(), null)).withRel("resetPassword"));
		return model;
	}

}