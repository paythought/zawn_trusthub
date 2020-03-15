package com.zawn.domain;

import java.util.HashMap;
import java.util.Map;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Users
 * <p>
 *
 *
 */
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"username", "password", "type", "hidden", "status", "verified", "notes"}) //, "timeline" 
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Users extends AbstractDocument {
	@Indexed(unique = true)
	@JsonProperty("username")
	private String username=null;
	@JsonProperty("password")
	public String password=null;
	@JsonProperty("type")
	public Type type=null;
	
	@JsonProperty("hidden")
	public Boolean hidden=null;
	@JsonProperty("status")
	public StatusEnum status=null;
	@JsonProperty("verified")
	public Boolean verified=null;
	@JsonProperty("notes")
	public String notes=null;
//	@JsonProperty("timeline")
//	@Valid
//	@DBRef
//	public List<Logs> timeline = new ArrayList<>();

	public enum Type {
		OPERATOR("OPERATOR"), ADMIN("ADMIN"), COMPANY("COMPANY"), PERSON("PERSON"),PARTNER("PARTNER");
		private final String value;
		private final static Map<String, Users.Type> CONSTANTS = new HashMap<>();

		static {
			for (Users.Type c : values()) {
				CONSTANTS.put(c.value, c);
			}
		}

		private Type(String value) {
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
		public static Users.Type fromValue(String value) {
			Users.Type constant = CONSTANTS.get(value);
			if (constant == null) {
				throw new IllegalArgumentException(value);
			} else {
				return constant;
			}
		}

	}
	
}