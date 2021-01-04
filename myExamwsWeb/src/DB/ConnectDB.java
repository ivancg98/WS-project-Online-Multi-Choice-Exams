package DB;

import java.sql.*;

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
				System.out.print("Connect success  ");
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
	
	public boolean createTables() {
		ConnectDB con = new ConnectDB();

		try {
			Statement st = con.connect().createStatement();
			String sql = 
			"CREATE TABLE Server (" +
				"Key	serial," +
				"Ip			varchar(20) NOT NULL, " +
				"Port		varchar(20) NOT NULL, " +
			    "PRIMARY KEY (Key), " +
				"UNIQUE(Ip,Port) " +
				"); " +

			"CREATE TABLE Exam ( " +
				"Key	serial, " +
				"Description		varchar(50) NOT NULL, " +
				"Date			varchar(10) NOT NULL, " +
				"Time 			varchar(8) NOT NULL, " +
				"Location int, " +
				"PRIMARY KEY (Key), " +
				"FOREIGN KEY (Location) REFERENCES Server(Key), " +
				"UNIQUE(Location) " +
				
				"); " +

			"CREATE TABLE Client ( " +
				"Key			varchar(12), " + 
				"ExamKey 			int, " +
				"Grade 				float, " +
				"HasGrade			boolean, " +
				"PRIMARY KEY (Key, ExamKey), " +
				"FOREIGN KEY (ExamKey) REFERENCES Exam(Key) " + 
				
				");";
			st.executeUpdate(sql);
			st.close();

		} catch (Exception e) {
			System.out.println("ERROR:" + e);
			return false;
		}

		con.disconnect();
		return true;
		
	}
	
	public boolean emptyTables() {
		ConnectDB con = new ConnectDB();
		try {
			Statement st = con.connect().createStatement();
			String sql = "TRUNCATE TABLE exam RESTART IDENTITY CASCADE;" + 
						" TRUNCATE TABLE server RESTART IDENTITY CASCADE;" + 
						" TRUNCATE TABLE client RESTART IDENTITY CASCADE;";
		} catch (Exception e) {
			System.out.println("ERROR:" + e);
			return false;
		}

		con.disconnect();
		return true;
	}
	
	public boolean deleteTables() {
		ConnectDB con = new ConnectDB();
		try {
			Statement st = con.connect().createStatement();
			String sql = "DROP TABLE Server CASCADE; " +
			"DROP TABLE Client CASCADE; " +
			"DROP TABLE Exam CASCADE; ";
			st.executeUpdate(sql);
			st.close();
		} catch (Exception e) {
			System.out.println("ERROR:" + e);
			return false;
		}

		con.disconnect();
		return true;
}


	
}
