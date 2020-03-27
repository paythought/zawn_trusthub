package com.zawn.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.afford;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import com.zawn.domain.Users;
import com.zawn.dto.JwtResponse;

@Component
public class LoginModelAssembler implements RepresentationModelAssembler<JwtResponse, EntityModel<JwtResponse>> {

	@Override
	public EntityModel<JwtResponse> toModel(JwtResponse jwtResponse) {

		EntityModel<JwtResponse> model = new EntityModel<>(jwtResponse,
				linkTo(methodOn(UserController.class).one(jwtResponse.getUsers().getId())).withSelfRel()
				//TODO Not generated links in JSON
				.andAffordance(afford(methodOn(UserController.class).insertUser(null)))
				.andAffordance(afford(methodOn(UserController.class).updateUser(jwtResponse.getUsers().getId(), null)))
				.andAffordance(afford(methodOn(UserController.class).deleteUser(jwtResponse.getUsers().getId())))
				
				,linkTo(methodOn(UserController.class).all()).withRel("user"));
		// Add a link resetPassword
//		model.add(
//				linkTo(methodOn(UserController.class).resetUserPassword(user.getId(), null)).withRel("resetPassword"));
		return model;
	}

}