package com.example.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.example.model.Purchase;

@Repository
public class PurchaseDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<Purchase> purchaseReport() {

		return jdbcTemplate.query("select * from Purchase", new RowMapper<Purchase>() {

			public Purchase mapRow(ResultSet rs, int rowNum) throws SQLException {

				Purchase purchase = new Purchase();
				purchase.setUserName(rs.getString(1));
				purchase.setOrderId(rs.getInt(2));
				purchase.setDate(rs.getString(3));
				purchase.setCategory(rs.getString(4));
				return purchase;
			}
		});
	}
}
