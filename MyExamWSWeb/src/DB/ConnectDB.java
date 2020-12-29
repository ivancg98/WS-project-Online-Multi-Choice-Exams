package DB;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDB {
	
	static String db = "myExamwsData";
	static String user = "postgres";
	static String password = "123456";
	static String url = "jdbc:postgresql://localhost:5432/myExamwsData";
	Connection connection = null; 


	public ConnectDB() {
		try {
			connection = DriverManager.getConnection(url, user, password);
			
			if(connection != null) {
				System.out.print("Connect ok");
			}
		}catch(Exception e){
			System.out.print("Error: "+e);
		}
	}
	
	public Connection connect() {
		return connection;
	}
	
	public void disconnect() {
		connection = null;
	}
		

}
