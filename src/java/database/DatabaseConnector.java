package database;

import java.sql.*;

public class DatabaseConnector {

	public static Connection getDatabase() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_database", "root", "nikita");

			return con;
		} catch (Exception e) {
			System.out.println(e);
		}

		return null;
	}

}