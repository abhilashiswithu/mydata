

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Singleton
public class MysqlConnector {
	private static MysqlConnector instance = null;
	private Connection connection = null;

	private MysqlConnector() {
		String url = "jdbc:mysql://localhost:3306/";
		String dbName = "hospital";
		String driver = "com.mysql.jdbc.Driver";
		String userName = "root";
		String password = "";

		try {
			Class.forName(driver).newInstance();
			connection = DriverManager.getConnection(url + dbName, userName,
					password);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Connection is created");

	}

	public Connection getConnection() {
		return connection;
	}

	public static MysqlConnector getInstance() {
		if (null == instance) {
			instance = new MysqlConnector();
		}
		return instance;
	}

	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		connection.close();
		System.out.println("Connection is closed");
	}

}
