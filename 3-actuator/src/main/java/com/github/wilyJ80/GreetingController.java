package com.github.wilyJ80;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public final class GreetingController {

	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/")
	public String getIndex(Model model) {
		counter.incrementAndGet();
		model.addAttribute("counter", counter);
		return "index";
	}

}
