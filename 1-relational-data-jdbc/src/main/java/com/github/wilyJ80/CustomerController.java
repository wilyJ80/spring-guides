package com.github.wilyJ80;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public final class CustomerController {
	private final CustomerDao customerDao;

	public CustomerController(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	@GetMapping("/")
	public String getIndex(Model model) {
		List<Customer> customers = this.customerDao.findAll();
		model.addAttribute("customers", customers);
		return "customers";
	}

	@GetMapping("/add")
	public String getAdd(Model model) {
		model.addAttribute("customer", new Customer());
		return "add";
	}

	@PostMapping("/add")
	public String addCustomer(@ModelAttribute Customer customer, RedirectAttributes attributes) {
		this.customerDao.addCustomer(customer);
		attributes.addFlashAttribute("message", "Customer Added");
		return "redirect:/";
	}

	@GetMapping("/search")
	public String getSearchResults(@RequestParam String firstName, Model model) {
		List<Customer> customers = this.customerDao.findByFirstName(firstName);
		model.addAttribute("customers", customers);
		return "search";
	}

}
