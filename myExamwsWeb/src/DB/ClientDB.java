package DB;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import entities.Client;


public class ClientDB {
	
	public boolean insertClient(Client client) {
		ConnectDB con = new ConnectDB();
		
		try {
			Statement st = con.connect().createStatement();
			String sql = "INSERT INTO client (key, keyExam) VALUES('"+client.getKey()+"' , "+client.getExamKey()+");";
			st.executeUpdate(sql);
			st.close();
			
		}catch(Exception e) {
			System.out.println("ERROR:"+e);
			return false;
		}
		
		con.disconnect();
		return true;
		
	}
	
	public boolean uploadGrade(Client c, float g) {
		ConnectDB con = new ConnectDB();
		
		try {
			Statement st = con.connect().createStatement();
			String sql = "INSERT INTO client (grade) VALUES("+g+") WHERE key = '"+c.getKey()+"' AND keyexam = "+c.getExamKey()+";";
			st.executeUpdate(sql);
			st.close();
			
		}catch(Exception e) {
			System.out.println("ERROR:"+e);
			return false;
		}
		
		con.disconnect();
		return true;
		
	}
	
	public ArrayList<Client> getListClientsOfExam(int k){
		ConnectDB con = new ConnectDB();
		ArrayList<Client> listClientsOfExam = new ArrayList<>();
		
		try {
			Statement st = con.connect().createStatement();
			String sql = "SELECT * FROM client WHERE keyexam = "+k+";";
			ResultSet resultQuery = st.executeQuery(sql);
			while(resultQuery.next()) {
				String key = resultQuery.getString("key");
				int keyExam = Integer.parseInt(resultQuery.getString("keyexam"));
				float grade = Float.parseFloat(resultQuery.getString("grade"));
				
				Client client = new Client(key, keyExam, grade);
				listClientsOfExam.add(client);
			}
			
		}catch(Exception e){
			System.out.println("Error: "+e);
		}

		con.disconnect();
		return listClientsOfExam;
	}
	
	public ArrayList<Client> getListClientsAllExams(int k){
		ConnectDB con = new ConnectDB();
		ArrayList<Client> listClientsAllExams = new ArrayList<>();
		
		try {
			Statement st = con.connect().createStatement();
			String sql = "SELECT * FROM client ;";
			ResultSet resultQuery = st.executeQuery(sql);
			while(resultQuery.next()) {
				String key = resultQuery.getString("key");
				int keyExam = Integer.parseInt(resultQuery.getString("keyexam"));
				float grade = Float.parseFloat(resultQuery.getString("grade"));
				
				Client client = new Client(key, keyExam, grade);
				listClientsAllExams.add(client);
			}
			
		}catch(Exception e){
			System.out.println("Error: "+e);
		}

		con.disconnect();
		return listClientsAllExams;
	}
	
	public ArrayList<Client> getListGradesOfClient(String k){
		ConnectDB con = new ConnectDB();
		ArrayList<Client> listGradesOfClient = new ArrayList<>();
		
		try {
			Statement st = con.connect().createStatement();
			String sql = "SELECT * FROM client WHERE key = '"+k+"';";
			ResultSet resultQuery = st.executeQuery(sql);
			while(resultQuery.next()) {
				String key = resultQuery.getString("key");
				int keyExam = Integer.parseInt(resultQuery.getString("keyexam"));
				float grade = Float.parseFloat(resultQuery.getString("grade"));
				
				Client client = new Client(key, keyExam, grade);
				listGradesOfClient.add(client);
			}
			
		}catch(Exception e){
			System.out.println("Error: "+e);
		}

		con.disconnect();
		return listGradesOfClient;
	}
	
	public boolean hasExamGrades(int k) {
		ConnectDB con = new ConnectDB();
		boolean hasGrades; 
		
		try {
		Statement st = con.connect().createStatement();
		String sql = "SELECT * FROM client WHERE key = '"+k+"' AND grade IS NOT NULL ;";
		hasGrades = st.execute(sql);
		
		}catch(Exception e){
			System.out.println("Error: "+e);
			return false;
		}

		con.disconnect();
		return hasGrades;
	}
	
	
	
	
	
	
	
	

}
