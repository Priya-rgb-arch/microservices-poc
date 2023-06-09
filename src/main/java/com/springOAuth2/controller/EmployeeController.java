package com.springOAuth2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class EmployeeController {

	@GetMapping("/employee/{name}")
	public String employee(@PathVariable("name") String name) {
		return "emloyee" + name;
	}
}
