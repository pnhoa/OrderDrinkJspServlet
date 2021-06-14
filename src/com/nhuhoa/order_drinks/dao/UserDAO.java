package com.nhuhoa.order_drinks.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.nhuhoa.order_drinks.bo.Users;
import com.nhuhoa.order_drinks.dbconnection.ConnectionFactory;

public class UserDAO {
	public void insertUser(String username, String email, String phone, String address, String password) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			String insertSQL = "INSERT INTO users (username,email,phone,address,password,role)"
					+ "VALUES (?,?,?,?,?,?)";
			connection = ConnectionFactory.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, email);
			preparedStatement.setString(3, phone);
			preparedStatement.setString(4, address);
			preparedStatement.setString(5, password);
			preparedStatement.setString(6, "user");
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean isUsernameExists(String username) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			connection = ConnectionFactory.getConnection();
			String sql = "SELECT * FROM users WHERE username= '" + username + "'";
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean isEmailExists(String email) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			connection = ConnectionFactory.getConnection();
			String sql = "SELECT * FROM users WHERE email= '" + email + "'";
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean isPhoneExists(String phone) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			connection = ConnectionFactory.getConnection();
			String sql = "SELECT * FROM users WHERE phone= '" + phone + "'";
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public Users findByUsernameAndPassword(String username, String password) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			connection = ConnectionFactory.getConnection();
			String sql = "SELECT * FROM users WHERE username= '" + username + "' AND password ='" + password + "'";
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				return covertToUser(resultSet);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	public Users findById(int user_id) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			connection = ConnectionFactory.getConnection();
			String sql = "SELECT * FROM users WHERE user_id=" + user_id;
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				return covertToUser(resultSet);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	private static Users covertToUser(ResultSet rs) throws SQLException {
		Users user = new Users();
		user.setUser_id(rs.getInt(1));
		user.setUsername(rs.getString(2));
		user.setEmail(rs.getString(3));
		user.setPhone(rs.getString(4));
		user.setAddress(rs.getString(5));
		user.setPassword(rs.getString(6));
		user.setRole(rs.getString(7));
		return user;
	}
}
