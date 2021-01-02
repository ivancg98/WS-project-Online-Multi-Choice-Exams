package DB;

import entities.Exam;
import java.sql.*;
import java.util.ArrayList;

public class ExamDB {

	public boolean insert(Exam exam) {
		ConnectDB con = new ConnectDB();
		
		try {
			Statement st = con.connect().createStatement();
			String sql = "INSERT INTO exam (description, date, time, location) VALUES('"+exam.getDescription()+"' , '"+exam.getDate()+"' , '"+exam.getTime()+"', "+exam.getLocation()+" );";
			st.executeUpdate(sql);
			st.close();
			
			
		}catch(Exception e) {
			System.out.println("ERROR:"+e);
			return false;
		}
		
		con.disconnect();
		return true;
		
	}
	
	public ArrayList<Exam> getAll(){
		ConnectDB con = new ConnectDB();
		ArrayList<Exam> listExams = new ArrayList<>();
		
		try {
			Statement st = con.connect().createStatement();
			String sql = "SELECT * FROM exam;";
			ResultSet resultQuery = st.executeQuery(sql);
			while(resultQuery.next()) {
				int key = Integer.parseInt(resultQuery.getString("key"));
				String description = resultQuery.getString("description");
				String date = resultQuery.getString("date");
				String time = resultQuery.getString("time");
				int location = Integer.parseInt(resultQuery.getString("location"));
				
				Exam exam = new Exam(key, description, date, time, location);	
				listExams.add(exam);
			}
			
		}catch(Exception e){
			System.out.println("Error: "+e);
		}

		con.disconnect();
		return listExams;
	}
	
	
	public Exam getFromKey(int k) {
		ConnectDB con = new ConnectDB();
		Exam exam = new Exam();
		
		try {
			Statement st = con.connect().createStatement();
			String sql = "SELECT * FROM exam WHERE key = "+k+";";
			ResultSet resultQuery = st.executeQuery(sql);
			if(resultQuery.next()) {
				int key = Integer.parseInt(resultQuery.getString("key"));
				String description = resultQuery.getString("description");
				String date = resultQuery.getString("date");
				String time = resultQuery.getString("time");
				int location = Integer.parseInt(resultQuery.getString("location"));
			
				exam.setKey(key);
				exam.setDescription(description);
				exam.setDate(date);
				exam.setTime(time);
				exam.setLocation(location);
			}
			
		}catch(Exception e){
			System.out.println("Error: "+e);
		}
		

		con.disconnect();
		return exam;
	}
	
	
	public boolean delete(int key) {
		ConnectDB con = new ConnectDB();
		
		try {
			Statement st = con.connect().createStatement();
			String sql = "DELETE FROM EXAM WHERE key = "+key+";";
			st.executeUpdate(sql);
			st.close();
			
			
		}catch(Exception e) {
			System.out.println("ERROR:"+e);
		}
		
		con.disconnect();
		return true;
		
	}
	
	public boolean updateDescription(int key, Exam modifiedExam) {
		ConnectDB con = new ConnectDB();
		
		try {
			Statement st = con.connect().createStatement();
			String sql = "UPDATE EXAM SET description = '" + modifiedExam.getDescription() + "' WHERE key = '" + key + "';";
			st.executeUpdate(sql);
			st.close();
			
			
		}catch(Exception e) {
			System.out.println("ERROR:"+e);
			return false;
		}
		
		con.disconnect();
		return true;
		
	}
	
	public ArrayList<Exam> exactSearch(String search){

		String sql = "SELECT * FROM exam WHERE description = '" + search + "';";
		
		return obtainAllQuery(sql);
	}
	
	public ArrayList<Exam> partialSearch(String search) {
		String query = "SELECT * FROM content WHERE description LIKE '%" + search + "%';";
		return obtainAllQuery(query);
	}
	
	public ArrayList<Exam> obtainAllQuery (String sql){
		ConnectDB con = new ConnectDB();
		ArrayList<Exam> listExams = new ArrayList<>();
		
		try {
			Statement st = con.connect().createStatement();
			ResultSet resultQuery = st.executeQuery(sql);
			while(resultQuery.next()) {
				int key = Integer.parseInt(resultQuery.getString("key"));
				String description = resultQuery.getString("description");
				String date = resultQuery.getString("date");
				String time = resultQuery.getString("time");
				int location = Integer.parseInt(resultQuery.getString("location"));
				
				Exam exam = new Exam(key, description, date, time, location);	
				listExams.add(exam);
			}
			
		}catch(Exception e){
			System.out.println("Error: "+e);
		}

		con.disconnect();
		return listExams;
	}
	
	
}
