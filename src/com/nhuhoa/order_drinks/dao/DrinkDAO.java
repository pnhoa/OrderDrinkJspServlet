package com.nhuhoa.order_drinks.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.nhuhoa.order_drinks.bo.Drinks;
import com.nhuhoa.order_drinks.dbconnection.ConnectionFactory;

public class DrinkDAO {
	public ArrayList<Drinks> getAllDrinks() {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		ArrayList<Drinks> drinkList = new ArrayList<Drinks>();
		try {
			connection = ConnectionFactory.getConnection();
			String sql = "SELECT * FROM drinks ";
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				drinkList.add(convertToDrink(resultSet));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return drinkList;

	}

	public ArrayList<Drinks> getAllCaPhe() {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		ArrayList<Drinks> drinkList = new ArrayList<Drinks>();
		try {
			connection = ConnectionFactory.getConnection();
			String sql = "SELECT * FROM drinks WHERE type= 'Cà Phê'";
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				drinkList.add(convertToDrink(resultSet));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return drinkList;
	}

	public ArrayList<Drinks> getAllTra() {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		ArrayList<Drinks> drinkList = new ArrayList<Drinks>();
		try {
			connection = ConnectionFactory.getConnection();
			String sql = "SELECT * FROM drinks WHERE type= 'Trà Trái Cây'";
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				drinkList.add(convertToDrink(resultSet));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return drinkList;
	}

	public ArrayList<Drinks> getAllDaXay() {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		ArrayList<Drinks> drinkList = new ArrayList<Drinks>();
		try {
			connection = ConnectionFactory.getConnection();
			String sql = "SELECT * FROM drinks WHERE type= 'Vitamin Đá Xay'";
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				drinkList.add(convertToDrink(resultSet));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return drinkList;
	}

	public ArrayList<Drinks> getAllNuocEp() {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		ArrayList<Drinks> drinkList = new ArrayList<Drinks>();
		try {
			connection = ConnectionFactory.getConnection();
			String sql = "SELECT * FROM drinks WHERE type= 'Nước Trái Cây'";
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				drinkList.add(convertToDrink(resultSet));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return drinkList;
	}

	public ArrayList<Drinks> getAllSuaChua() {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		ArrayList<Drinks> drinkList = new ArrayList<Drinks>();
		try {
			connection = ConnectionFactory.getConnection();
			String sql = "SELECT * FROM drinks WHERE type= 'Sữa Chua'";
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				drinkList.add(convertToDrink(resultSet));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return drinkList;
	}

	public void deleteDrink(int id) {
		Connection connection = null;
		Statement statement = null;

		try {
			connection = ConnectionFactory.getConnection();
			String sql = "DELETE FROM drinks WHERE drink_id=" + id;
			statement = connection.createStatement();
			statement.executeUpdate(sql);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insertDrink(String drink_name, String type, String description, double price, String image) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			String insertSQL = "INSERT INTO drinks (drink_name,type,description,price,image)" + "VALUES (?,?,?,?,?)";
			connection = ConnectionFactory.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, drink_name);
			preparedStatement.setString(2, type);
			preparedStatement.setString(3, description);
			preparedStatement.setDouble(4, price);
			preparedStatement.setString(5, image);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Drinks findById(int drink_id) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			connection = ConnectionFactory.getConnection();
			String sql = "SELECT * FROM drinks WHERE drink_id=" + drink_id;
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				return convertToDrink(resultSet);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	public void updateDrink(int drink_id, String drink_name, String type, String description, double price,
			String image) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = ConnectionFactory.getConnection();
			String sql = "UPDATE drinks SET drink_name= ?, type = ?, description = ?, price = ?, image = ? WHERE drink_id = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, drink_name);
			preparedStatement.setString(2, type);
			preparedStatement.setString(3, description);
			preparedStatement.setDouble(4, price);
			preparedStatement.setString(5, image);
			preparedStatement.setInt(6, drink_id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static Drinks convertToDrink(ResultSet rs) throws SQLException {
		Drinks drink = new Drinks();
		drink.setDrink_id(rs.getInt(1));
		drink.setDrink_name(rs.getString(2));
		drink.setType(rs.getString(3));
		drink.setDescription(rs.getString(4));
		drink.setPrice(rs.getDouble(5));
		drink.setImage(rs.getString(6));

		return drink;
	}

	public ArrayList<Drinks> searchByDrink(String search) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		ArrayList<Drinks> drinkList = new ArrayList<Drinks>();
		try {

			connection = ConnectionFactory.getConnection();
			String sql = "SELECT * FROM drinks WHERE drink_name = '" + search + "'";
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				drinkList.add(convertToDrink(resultSet));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return drinkList;

	}
}
