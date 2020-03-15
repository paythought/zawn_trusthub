package com.zawn.domain.authen;

import java.math.BigInteger;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.zawn.domain.StatusEnum;
import com.zawn.domain.Users;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO {
	@JsonProperty("id")
	private BigInteger id;
	
	@JsonProperty("username")
	public String username;
	@JsonProperty("password")
	public String password;
	@JsonProperty("type")
	public Users.Type type;
	
	@JsonProperty("hidden")
	public Boolean hidden;
	@JsonProperty("status")
	public StatusEnum status;
	@JsonProperty("verified")
	public Boolean verified;
	@JsonProperty("notes")
	public String notes;
}