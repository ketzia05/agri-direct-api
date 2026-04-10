package com.example.agrimarket;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {
	
	@GetMapping("/hello")
	public String hello() {
		return "Hello, Thanks for choosing AgriDirect :)";
	}
	
	@GetMapping("/")
	public String usual() {
		return "!!! Welcome to AgriDirect !!!";
	}
}
