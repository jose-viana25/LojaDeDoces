package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	
	private static ConnectionManager instance;
	private Connection connection;
	private String databaseUrl = "jdbc:mariadb://localhost:3306/lojadedoces";
	private String user = "root";
	private String password = "$(Tiger123)";
	
	private ConnectionManager() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public static ConnectionManager getInstance() {
		if (instance == null) {
			instance = new ConnectionManager();
		}
		return instance;
	}
	
	public Connection getConnection() throws SQLException {
		
		if (connection == null || connection.isClosed()) {
			connection = DriverManager.getConnection(databaseUrl,user,password);
		}
		
		return connection;
	}

}
