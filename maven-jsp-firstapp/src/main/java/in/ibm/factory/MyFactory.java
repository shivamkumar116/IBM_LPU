package in.ibm.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyFactory {

	private Connection connection;
	private static MyFactory factory;

	private MyFactory() throws SQLException {
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ibm", "root", "vk7j5qaMX%");
	}

	public static MyFactory getMyFactory() throws SQLException {
		if (factory == null) {
			factory = new MyFactory();
			return factory;
		} else
			return factory;

	}

	public Connection getMyConnection() {
		return connection;
	}

}
