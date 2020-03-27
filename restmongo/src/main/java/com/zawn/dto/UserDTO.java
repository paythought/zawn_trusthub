package com.zawn.dto;

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
	private String id=null;
	
	@JsonProperty("username")
	public String username=null;
	@JsonProperty("password")
	public String password=null;
	@JsonProperty("type")
	public Users.Type type=null;
	
	@JsonProperty("hidden")
	public Boolean hidden=null;
	@JsonProperty("status")
	public StatusEnum status=null;
	@JsonProperty("verified")
	public Boolean verified=null;
	@JsonProperty("notes")
	public String notes=null;
}