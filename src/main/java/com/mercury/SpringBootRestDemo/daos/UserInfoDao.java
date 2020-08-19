package com.mercury.SpringBootRestDemo.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mercury.SpringBootRestDemo.beans.UserInfo;

public interface UserInfoDao extends JpaRepository<UserInfo, Integer>{

}
