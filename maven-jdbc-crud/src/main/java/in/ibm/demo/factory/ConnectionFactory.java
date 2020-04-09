package in.ibm.demo.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	private Connection connection = null;
	public static ConnectionFactory factory = null;

	// using the singleton design pattern by using the keyword private with
	// constructor
	private ConnectionFactory() {
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ibm", "root", "vk7j5qaMX%");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public Connection getMyConnection() {
		return connection;
	}

	public static ConnectionFactory getConnectionObject() {
		if (factory == null) {
			factory = new ConnectionFactory();
		}
		return factory;
	}

}
