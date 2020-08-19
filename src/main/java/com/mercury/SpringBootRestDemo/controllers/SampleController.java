package com.mercury.SpringBootRestDemo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercury.SpringBootRestDemo.beans.Sample;

@RestController		// @RestController = @Controller + @ResponseBody
@RequestMapping("/samples")
public class SampleController {

	@RequestMapping("/foo")
	public String foo() {
		// http://localhost:8080/foo
		// http://localhost:8080/samples/foo
		return "foo";
	}
	
	
	@PostMapping
	public void saveSample(@RequestBody Sample sample) {
		// Post Request
		// http://localhost:8080/samples
		
		System.out.println(sample + " is saved!");
	}
	
	@PostMapping("/{level}")
	public void test(@RequestBody Sample sample, @PathVariable("level") int level) {
		System.out.println(sample + " is level: " + level);
	}
	
	@GetMapping("/nameAge/{x}/{y}")
	public Sample getSampleByNameAndAge(@PathVariable("x") String name, @PathVariable("y") int age) {
		// http://localhost:8080/samples/Rex/44
		// http://localhost:8080/samples?name=A&age=2	NOT RESTFUL STYLE
		return new Sample(name, age);
	}
	
	@GetMapping("/{name}")
	public Sample getSampleByName(@PathVariable("name") String name) {
		return new Sample(name, 100);
	}
	
	@GetMapping("/age/{age}")
	public List<Sample> getSamplesByAge(@PathVariable("age") int age) {
		
		List<Sample> samples = new ArrayList();
		samples.add(new Sample("Jim", age));
		samples.add(new Sample("Thorpe", age));
		
		return samples;
	}
	
	@GetMapping
	public List<Sample> getAll() {
		// Get Request
		// http://localhost:8080/samples
		
		List<Sample> samples = new ArrayList();
		samples.add(new Sample("Jim", 12));
		samples.add(new Sample("Thorpe", 22));
		
		return samples;
	}
	
	@PutMapping
	public void updateSample(@RequestBody Sample sample) {
		// Put Request
		// http://localhost:8080/samples
		System.out.println(sample + " is updated!");
	}
	
	@DeleteMapping("/{name}")
	public void deleteSampleByName(@PathVariable("name") String name) {
		System.out.println(name + " is deleted!");
	}
}
