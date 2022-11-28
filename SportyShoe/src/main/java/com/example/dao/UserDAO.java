package com.example.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.example.model.User;

@Repository
public class UserDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<User> userList() {

		return jdbcTemplate.query("select * from User1", new RowMapper<User>() {

			public User mapRow(ResultSet rs, int rowNum) throws SQLException {

				User user = new User();
				user.setUsername(rs.getString(1));
				user.setUserId(rs.getInt(2));
				user.setPassword(rs.getString(3));
				user.setDateBooked(rs.getString(4));
				return user;
			}
		});
	}

	public String validateUser(String username, String password) {
		List<User> list = userList();
		int length = list.size();
		for (int i = 0; i < length; i++) {
			String u = list.get(i).getUsername();
			String p = list.get(i).getPassword();
			if ((u.equals(username)) && (p.equals(password))) {
				return "success";
			}
		}
		return "Invalid crenditals";
	}

	public String changePassword(String username, String newPass) {
		System.out.println(newPass);
		String updateQuery = "UPDATE User1 set password=? where username=?";
		jdbcTemplate.update(updateQuery, newPass, username);
		return "Updated password";
	}
}
