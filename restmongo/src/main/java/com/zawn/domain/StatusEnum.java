package com.zawn.domain;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum StatusEnum {

	ENABLED("ENABLED"), DISABLED("DISABLED"), DELETED("DELETED");
	private final String value;
	private final static Map<String, StatusEnum> CONSTANTS = new HashMap<String, StatusEnum>();

	static {
		for (StatusEnum c : values()) {
			CONSTANTS.put(c.value, c);
		}
	}

	private StatusEnum(String value) {
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
	public static StatusEnum fromValue(String value) {
		StatusEnum constant = CONSTANTS.get(value);
		if (constant == null) {
			throw new IllegalArgumentException(value);
		} else {
			return constant;
		}
	}

}