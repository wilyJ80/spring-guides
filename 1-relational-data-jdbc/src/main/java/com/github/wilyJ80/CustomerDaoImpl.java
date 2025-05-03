package com.github.wilyJ80;

import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDaoImpl implements CustomerDao {
	private final JdbcTemplate jdbcTemplate;

	public CustomerDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Customer> findAll() {
		String sql = """
				select id, firstname, lastname from customers order by id
						""";
		return jdbcTemplate.query(sql, new CustomerRowMapper());
	}

	@Override
	public List<Customer> findByFirstName(String firstName) {
		String sql = """
				select id, firstname, lastname from customers where firstname = ?
						""";
		return jdbcTemplate.query(sql, new CustomerRowMapper(), firstName);
	}

	@Override
	public int addCustomer(Customer customer) {
		String sql = """
				insert into customers (firstname, lastname) values (?, ?)
				""";
		return jdbcTemplate.update(sql, customer.getFirstName(), customer.getLastName());
	}
}
