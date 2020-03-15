package com.zawn.domain;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum StatusWithSuspendedEnum {

	ENABLED("ENABLED"), DISABLED("DISABLED"), SUSPENDED("SUSPENDED"), DELETED("DELETED");
	private final String value;
	private final static Map<String, StatusWithSuspendedEnum> CONSTANTS = new HashMap<>();

	static {
		for (StatusWithSuspendedEnum c : values()) {
			CONSTANTS.put(c.value, c);
		}
	}

	private StatusWithSuspendedEnum(String value) {
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
	public static StatusWithSuspendedEnum fromValue(String value) {
		StatusWithSuspendedEnum constant = CONSTANTS.get(value);
		if (constant == null) {
			throw new IllegalArgumentException(value);
		} else {
			return constant;
		}
	}

}
