package com.zawn.service;

import org.springframework.security.core.GrantedAuthority;

public interface UserRole {
	static final String ROLE_ADMIN = "roleAdmin";
	static final String ROLE_OPERATOR = "roleOperator";
	static final GrantedAuthority AUTHORITY_ADMIN = new GrantedAuthority() {

		@Override
		public String getAuthority() {
			return ROLE_ADMIN ;
		}
	};
	
	static final GrantedAuthority AUTHORITY_OPERATOR = new GrantedAuthority() {

		@Override
		public String getAuthority() {
			return ROLE_OPERATOR;
		}
	};
}
