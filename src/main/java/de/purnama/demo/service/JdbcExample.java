package de.purnama.demo.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import de.purnama.demo.model.UserData;

@Service
public class JdbcExample {

	@Value("${spring.datasource.url}")
	private String dbUrl;

	@Value("${spring.datasource.username}")
	private String username;

	@Value("${spring.datasource.password}")
	private String pass;

	public UserData getUserDataById(Long id) {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(dbUrl, username, pass);

			System.out.println("Creating statement...");
			String sql;
			sql = "SELECT * FROM user_data WHERE id=?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id.intValue());
			ResultSet rs = stmt.executeQuery();

			UserData userData = new UserData();
			while (rs.next()) {
				userData.setId(rs.getLong("id"));
				userData.setName(rs.getString("email"));
				userData.setUsername(rs.getString("username"));
			}

			rs.close();
			stmt.close();
			conn.close();
			return userData;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		return null;
	}
}
