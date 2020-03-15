package com.zawn.conversion;

import java.math.BigInteger;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.zawn.domain.Users;

@Component
public class UsersToIntConverter implements Converter<Users, BigInteger> {
	public BigInteger convert(Users source) {
		return source == null ? null : source.getId();
	}
}