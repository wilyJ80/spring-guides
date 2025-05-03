package com.github.wilyJ80;

import java.util.List;
import java.util.Optional;

public interface CustomerDao {

	List<Customer> findAll();

	List<Customer> findByFirstName(String firstName);

	int addCustomer(Customer customer);
}
