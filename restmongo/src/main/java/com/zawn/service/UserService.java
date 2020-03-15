package com.zawn.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.zawn.domain.Users;
import com.zawn.domain.authen.UserDTO;
import com.zawn.repository.UsersRepository;

@Service
public class UserService {

	@Autowired
	private UsersRepository userDao;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	public Users insert(UserDTO user) {
		Authentication userAuthen=SecurityContextHolder.getContext().getAuthentication();
		if(user.getType()==Users.Type.ADMIN) {
			if(userAuthen==null || userAuthen.getAuthorities()==null || 
					!userAuthen.getAuthorities().contains(UserRole.AUTHORITY_ADMIN))
				throw new AccessDeniedException("Only a user of type 'ADMIN' permitted to create 'ADMIN'.");
		}
		Users newUser = new Users();
		copyTo(newUser, user, true);
		return userDao.insert(newUser);
	}
	
	/**
	 * Update all field except password. 
	 * @param user
	 * @return
	 */
	public Users update(UserDTO user) {
		Users updatedUser = userDao.findById(user.getId()).orElseThrow(
				() -> new UserNotFoundException(user.getId().toString()));
		// Authorisation
		Authentication userAuthen=SecurityContextHolder.getContext().getAuthentication();
		if(user.getType()==Users.Type.ADMIN || updatedUser.getType() == Users.Type.ADMIN ) {
			if(userAuthen==null || userAuthen.getAuthorities()==null || 
					!userAuthen.getAuthorities().contains(UserRole.AUTHORITY_ADMIN))
				throw new AccessDeniedException("Only a user of type 'ADMIN' permitted to update 'ADMIN' user.");
		}
		copyTo(updatedUser, user, true);
		return userDao.save(updatedUser);
	}
	
	public Users resetPassword(UserDTO user) {
		Users updatedUser = userDao.findById(user.getId()).orElseThrow(
				() -> new UserNotFoundException(user.getId().toString()));
		updatedUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		return userDao.save(updatedUser);
	}
	
	public void delete(UserDTO user) {
		Users updatedUser = userDao.findById(user.getId()).orElseThrow(
				() -> new UserNotFoundException(user.getId().toString()));
			
			// Authorisation
			Authentication userAuthen=SecurityContextHolder.getContext().getAuthentication();
			if(updatedUser.getType()==Users.Type.ADMIN ) {
				if(userAuthen==null || userAuthen.getAuthorities()==null || 
						!userAuthen.getAuthorities().contains(UserRole.AUTHORITY_ADMIN))
					throw new AccessDeniedException("Only a user of type 'ADMIN' permitted to delete 'ADMIN' user.");
			}
			userDao.delete(updatedUser);	
	}
	
	private void copyTo(Users updatedUser, UserDTO user, boolean resetPassword) {
		if(resetPassword)
			updatedUser.setPassword(bcryptEncoder.encode(user.getPassword())); 
		updatedUser.setHidden(user.getHidden());
		updatedUser.setUsername(user.getUsername());
		updatedUser.setType(user.getType());
		updatedUser.setStatus(user.getStatus());
		updatedUser.setNotes(user.getNotes());
		updatedUser.setVerified(user.getVerified());
	}

}