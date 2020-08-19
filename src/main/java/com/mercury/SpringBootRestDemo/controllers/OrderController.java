package com.mercury.SpringBootRestDemo.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercury.SpringBootRestDemo.beans.Order;
import com.mercury.SpringBootRestDemo.http.Response;
import com.mercury.SpringBootRestDemo.services.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Value("${app.name}")
	private String appName;

	@Autowired
	private OrderService orderService;
	
	// Spring Cache is function based
	// <input, output> will be cached
	// by default, cache in JVM, also can be configured to use 3rd party lib
	// 
	
	@GetMapping("/foo/{x}")
	@Cacheable("foo")
	public String foo(@PathVariable int x) {
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return appName + " foo x is: " + x;
	}
	
	// the name of the cache map, now foo() and bar() will share 1 same cache map
	// also have CacheEvict, CachePut ... to help renew / update the cache.
	
	@GetMapping("/bar/{x}")
	@Cacheable("foo")	
	public String bar(@PathVariable int x) {
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return "bar x is: " + 2 * x;
	}
	
	@GetMapping
	public List<Order> getAll() {
		int x = 5;
		
		logger.debug("Order getAll() debug log...");
		logger.info("Order getAll() info log...");
		// {} will not concatenate the strings if log level is lower than required
		logger.debug("x: " + x);
		logger.debug("x: {}", x);
		
		return orderService.getAll();
	}
	
	@GetMapping("/{id}")
	public Order getById(@PathVariable int id) {
		return orderService.getOrderById(id);
	}
	
	@PostMapping
	public Response save(@RequestBody Order order) {
		return orderService.save(order);
	}
	
	@GetMapping("/pdf/{id}")
	public String generatePdf(@PathVariable int id) {
//		Order order = new Order(id, null, null);
//		orderInfoProducer.sendOrderForReport(order);
		return appName;
	}
}
