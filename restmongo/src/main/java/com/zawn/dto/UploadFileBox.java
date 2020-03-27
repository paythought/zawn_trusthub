package com.zawn.dto;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.zawn.domain.Users;

public enum UploadFileBox {
	inbound("inbound"), outbound("outbound"), datastore("datastore");
	private final String value;
	private final static Map<String, UploadFileBox> CONSTANTS = new HashMap<>();

	static {
		for (UploadFileBox c : values()) {
			CONSTANTS.put(c.value, c);
		}
	}

	private UploadFileBox(String value) {
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
	public static UploadFileBox fromValue(String value) {
		UploadFileBox constant = CONSTANTS.get(value);
		if (constant == null) {
			throw new IllegalArgumentException(value);
		} else {
			return constant;
		}
	}

}