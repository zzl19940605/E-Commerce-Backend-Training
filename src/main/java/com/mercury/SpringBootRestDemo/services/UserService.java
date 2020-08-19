package com.mercury.SpringBootRestDemo.services;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mercury.SpringBootRestDemo.beans.Profile;
import com.mercury.SpringBootRestDemo.beans.User;
import com.mercury.SpringBootRestDemo.daos.UserDao;
import com.mercury.SpringBootRestDemo.http.Response;
import com.mercury.SpringBootRestDemo.security.utils.SecurityUtil;

@Service

public class UserService {
	
	private final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

	@Autowired
	UserDao userDao;

	@Autowired
	PasswordEncoder passwordEncoder;

	public Response register(User user) {
		// TODO: validation.
		try {
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			List<Profile> profiles = new ArrayList<Profile>();
			profiles.add(new Profile(2));
			user.setProfiles(profiles);
			userDao.save(user);
			return new Response(true);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return new Response(false, 400, e.getMessage());
		}
	}
	
	public Response changePassword(User user, Authentication authentication) {
		if(user.getUsername().equals(authentication.getName()) || SecurityUtil.isAdmin(authentication.getAuthorities())) {
			User u = userDao.findByUsername(user.getUsername());
			u.setPassword(passwordEncoder.encode(user.getPassword()));
			userDao.save(u);
		}else {
			//TODO: Not authorize to update password if not current loggedin user or admin.
			return new Response(false);
		}
		return new Response(true);
	}
	
	public Response deleteUser(int id) {
		if(userDao.findById(id).get() != null) {
			userDao.deleteById(id);
			return new Response(true);
		}else {
			return new Response(false, "User is not found!");
		}
	}

}
