package com.nhuhoa.order_drinks.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.nhuhoa.order_drinks.bo.Contacts;

import com.nhuhoa.order_drinks.dbconnection.ConnectionFactory;

public class ContactDAO {
	public ArrayList<Contacts> getAllContacts() {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		ArrayList<Contacts> contactList = new ArrayList<Contacts>();
		try {
			connection = ConnectionFactory.getConnection();
			String sql = "SELECT * FROM contacts";
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				contactList.add(convertToContact(resultSet));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return contactList;

	}

	public void insertContact(String firstname, String lastname, String email, String message) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			String insertSQL = "INSERT INTO contacts (firstname,lastname,email,message)" + "VALUES (?,?,?,?)";
			connection = ConnectionFactory.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, firstname);
			preparedStatement.setString(2, lastname);
			preparedStatement.setString(3, email);
			preparedStatement.setString(4, message);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private static Contacts convertToContact(ResultSet rs) throws SQLException {
		Contacts contact = new Contacts();
		contact.setContact_id(rs.getInt(1));
		contact.setFirstname(rs.getString(2));
		contact.setLastname(rs.getString(3));
		contact.setEmail(rs.getString(4));
		contact.setMessage(rs.getString(5));

		return contact;
	}

}
