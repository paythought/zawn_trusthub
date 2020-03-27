
package com.zawn.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Operations
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ 
	"name", 
	"description", 
	"icon", 
	"image", 
	"path", 
	"witness", 
	"parameters", 
	"amount", 
	"hidden","status", "verified", "notes", "logs" })
@Document
@Getter
@Setter
@NoArgsConstructor
public class Operations extends AbstractLoggedDocument {

	@JsonProperty("name")
	@NotEmpty
	@Indexed(unique = true)
	public String name;
	@JsonProperty("description")
	public String description;
	@JsonProperty("icon")
	public String icon;
	@JsonProperty("image")
	public String image;
	@JsonProperty("path")
	public String path;
	@JsonProperty("witness")
	public Boolean wtness;
	@JsonProperty("parameters")
	@Valid
	public List<String> parameters = new ArrayList<String>();
	@JsonProperty("amount")
	public String amount;
	@JsonProperty("hidden")
	@NotNull
	public Boolean hidden = false;
	@JsonProperty("status")
	@NotNull
	public Operations.Status status = Status.ENABLED;
	@JsonProperty("verified")
	@NotNull
	public Boolean verified = false;
	@JsonProperty("notes")
	public String notes;

	public enum Status {

		ENABLED("ENABLED"), DISABLED("DISABLED"), DELETED("DELETED");
		private final String value;
		private final static Map<String, Operations.Status> CONSTANTS = new HashMap<>();

		static {
			for (Operations.Status c : values()) {
				CONSTANTS.put(c.value, c);
			}
		}

		private Status(String value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return this.value;
		}

		@JsonValue
		public String value() {
			return this.value;
		}

		@JsonCreator
		public static Operations.Status fromValue(String value) {
			Operations.Status constant = CONSTANTS.get(value);
			if (constant == null) {
				throw new IllegalArgumentException(value);
			} else {
				return constant;
			}
		}

	}

}
