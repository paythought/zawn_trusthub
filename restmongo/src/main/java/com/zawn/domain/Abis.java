package com.zawn.domain;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Abis
 * <p>
 *
 *
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id_user", "hidden", "status", "verified", "notes", "timeline" })
@Getter
@Setter
@NoArgsConstructor
public class Abis extends AbstractDocument{
	@JsonProperty("id_user")
	public Users id_user;
	@JsonProperty("hidden")
	public Boolean hidden;
	@JsonProperty("status")
	public StatusEnum status;
	@JsonProperty("verified")
	public Boolean verified;
	@JsonProperty("notes")
	public String notes;
	@JsonProperty("timeline")
	@Valid
	public List<Logs> timeline = new ArrayList<>();

}