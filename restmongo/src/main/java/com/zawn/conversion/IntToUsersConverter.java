package com.zawn.conversion;

import java.math.BigInteger;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.zawn.domain.Users;

@Component
public class IntToUsersConverter implements Converter<String, Users> {
	public Users convert(String source) {
		throw new RuntimeException("The converter class IntToUsersConverter not implemented yet");
		//return source != null ? null : null;
	}
}
