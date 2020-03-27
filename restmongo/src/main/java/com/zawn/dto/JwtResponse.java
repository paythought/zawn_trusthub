package com.zawn.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.zawn.domain.Users;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"token", "user"})
public class JwtResponse implements Serializable {
	private static final long serialVersionUID = -8091879091924046844L;
	
	@JsonProperty("token")
	private final String jwttoken;
	
	@JsonProperty("user")
	private Users  users;
	public JwtResponse(String jwttoken) {
		this.jwttoken = jwttoken;
	}

	public String getToken() {
		return this.jwttoken;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}
	
}