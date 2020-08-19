package com.mercury.SpringBootRestDemo.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mercury.SpringBootRestDemo.beans.User;

public interface UserDao extends JpaRepository<User, Integer> {
	User findByUsername(String username);
}
