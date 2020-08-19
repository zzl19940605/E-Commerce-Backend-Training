package com.mercury.SpringBootRestDemo.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mercury.SpringBootRestDemo.beans.Order;

public interface OrderDao extends JpaRepository<Order, Integer> {

}
