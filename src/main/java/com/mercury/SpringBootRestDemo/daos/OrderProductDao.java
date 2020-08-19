package com.mercury.SpringBootRestDemo.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mercury.SpringBootRestDemo.beans.OrderProduct;

public interface OrderProductDao extends JpaRepository<OrderProduct, Integer> {

}
