package com.zawn.domain;

import java.math.BigInteger;

import org.springframework.data.annotation.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
public abstract class AbstractDocument {
	@Id
	private String id=null;
	
}
