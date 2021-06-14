package com.nhuhoa.order_drinks.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.nhuhoa.order_drinks.bo.Orders;

import com.nhuhoa.order_drinks.dbconnection.ConnectionFactory;

public class OrderDAO {
	public ArrayList<Orders> getAllOrders() {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		ArrayList<Orders> orderList = new ArrayList<Orders>();
		try {
			connection = ConnectionFactory.getConnection();
			String sql = "SELECT * FROM orders ";
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				orderList.add(covertToOrder(resultSet));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return orderList;

	}

	public ArrayList<Orders> getUserOrders(int user_id) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		ArrayList<Orders> orderList = new ArrayList<Orders>();
		try {
			connection = ConnectionFactory.getConnection();
			String sql = "SELECT * FROM orders WHERE user_id=" + user_id;
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				orderList.add(covertToOrder(resultSet));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return orderList;

	}

	public void insertOrder(int drink_id, int user_id, int quantity, double total, String comment) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			String insertSQL = "INSERT INTO orders (drink_id, user_id, quantity, total, order_date, comment)"
					+ "VALUES (?,?,?,?,?,?)";
			connection = ConnectionFactory.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setInt(1, drink_id);
			preparedStatement.setInt(2, user_id);
			preparedStatement.setInt(3, quantity);
			preparedStatement.setDouble(4, total);
			preparedStatement.setTimestamp(5, java.sql.Timestamp.valueOf(java.time.LocalDateTime.now()));
			preparedStatement.setString(6, comment);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Orders findByOrder_id(int order_id) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			connection = ConnectionFactory.getConnection();
			String sql = "SELECT * FROM orders WHERE order_id=" + order_id;
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				return covertToOrder(resultSet);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	private static Orders covertToOrder(ResultSet rs) throws SQLException {
		Orders order = new Orders();
		order.setOrder_id(rs.getInt(1));
		order.setDrink_id(rs.getInt(2));
		order.setUser_id(rs.getInt(3));
		order.setQuantity(rs.getInt(4));
		order.setTotal(rs.getDouble(5));
		order.setOrder_date(rs.getString(6));
		order.setComment(rs.getString(7));

		return order;
	}
}
