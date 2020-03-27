package com.zawn.service;

import org.springframework.security.core.GrantedAuthority;

public interface UserRole {
	static final String ROLE_ADMIN = "ADMIN";
	static final String ROLE_OPERATOR = "OPERATOR";
	static final String ROLE_PERSON = "PERSON";
	static final String ROLE_COMPANY = "COMPANY";
	static final String ROLE_PARTNER = "PARTNER";
	
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
	
	static final GrantedAuthority AUTHORITY_PERSON = new GrantedAuthority() {

		@Override
		public String getAuthority() {
			return ROLE_PERSON;
		}
	};
	
	static final GrantedAuthority AUTHORITY_COMPANY= new GrantedAuthority() {

		@Override
		public String getAuthority() {
			return ROLE_COMPANY;
		}
	};
	
	static final GrantedAuthority AUTHORITY_PARTNER= new GrantedAuthority() {

		@Override
		public String getAuthority() {
			return ROLE_PARTNER;
		}
	};
}
