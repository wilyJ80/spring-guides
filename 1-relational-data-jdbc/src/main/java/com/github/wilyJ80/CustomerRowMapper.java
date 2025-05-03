package com.github.wilyJ80;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public final class CustomerRowMapper implements RowMapper<Customer> {

	@Override
	public final Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Customer(rs.getInt("id"), rs.getString("firstname"), rs.getString("lastname"));
	}

}
