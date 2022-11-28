package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.model.Product;

@Repository
public class ProductDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<Product> getProducts() {
		return jdbcTemplate.query("select * from Product1", new RowMapper<Product>() {
			public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
				Product product = new Product();
				product.setProductNumber(rs.getInt(1));
				product.setProductName(rs.getString(2));
				product.setProductCategory(rs.getString(3));
				product.setProductPrice(rs.getInt(4));
				return product;
			}
		});
	}
	public void insertProduct(final int id, final String name,final String category,final int price) {
		final String insertQuery = "INSERT INTO PRODUCT1 VALUES(?,?,?,?)";
		
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				// TODO Auto-generated method stub
				Product product = new Product();
				PreparedStatement ps = con.prepareStatement(insertQuery);
				System.out.println(product.getProductNumber());
				ps.setInt(1,id);
				ps.setString(2,name);
				ps.setString(3, category);
				ps.setInt(4, price);
			//	ps.executeUpdate();
				System.out.println("order inserted");
				return ps;
			}
		});
	}
	
	public void deleteProduct(int id)
	{
		String deleteQuery ="DELETE FROM PRODUCT1 WHERE ORDERID=?";
			
		jdbcTemplate.update(deleteQuery,id);
		
		System.out.println("deleted successfully");
	}
}
