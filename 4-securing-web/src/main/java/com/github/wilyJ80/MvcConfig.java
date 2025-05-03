package com.github.wilyJ80;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
public final class MvcConfig {

	@GetMapping("/")
	public String getHome() {
		return "home";
	}

	@GetMapping("/hello")
	public String getHello() {
		return "hello";
	}

	@GetMapping("/login")
	public String getLogin() {
		return "login";
	}
}
