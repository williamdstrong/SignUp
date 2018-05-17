package data;

import data.Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
	
	protected Connection connect = null;
	protected Statement statement = null;
	protected PreparedStatement preparedStatement = null;
	protected ResultSet resultSet = null;
	
	protected void initDatabase() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			connect = DriverManager.getConnection("jdbc:mysql://localhost/user_information?user=root&password=teoe2012");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
