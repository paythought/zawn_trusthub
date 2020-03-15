package com.zawn.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.zawn.domain.Users;
import com.zawn.repository.UsersRepository;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	private UsersRepository userDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		if ("javainuse".equals(username)) {
//			return new User("javainuse", "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6",
//					new ArrayList<>());
//		} else {
//			throw new UsernameNotFoundException("User not found with username: " + username);
//		}
		Users user = findUsersByUsername(username);
		// TODO Role, Enabled management
		GrantedAuthority ga = user.getType() == Users.Type.ADMIN ? UserRole.AUTHORITY_ADMIN
				: UserRole.AUTHORITY_OPERATOR;
		ArrayList<GrantedAuthority> gaList = new ArrayList<>();
		gaList.add(ga);
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), gaList);
	}

	public Users findUsersByUsername(String username) throws UsernameNotFoundException {
		if (username == null || username.isEmpty()) {
			throw new UsernameNotFoundException("User can't be found with empty username.");
		}

		Users templ = new Users();
		templ.setUsername(username);
		Example<Users> example = Example.of(templ);
		Optional<Users> user = userDao.findOne(example);

		if (!user.isPresent()) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return user.get();
	}

}