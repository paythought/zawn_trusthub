package com.zawn.domain;

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
@JsonPropertyOrder({ "iduser", "hidden", "status", "verified", "notes" })
@Getter
@Setter
@NoArgsConstructor
public class Abis extends AbstractDocument{
	@JsonProperty("iduser")
	public Users iduser;
	@JsonProperty("hidden")
	public Boolean hidden;
	@JsonProperty("status")
	public StatusEnum status;
	@JsonProperty("verified")
	public Boolean verified;
	@JsonProperty("notes")
	public String notes;
}