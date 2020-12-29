package DB;

import entities.Exam;
import java.sql.*;
import java.util.ArrayList;

public class ExamDB {

	public String insert(Exam exam) {
		
		ConnectDB con = new ConnectDB();
		String result = "I don't know";
		
		
		try {
			Statement st = con.connect().createStatement();
			String sql = "INSERT INTO exam (description, date, time) VALUES('"+exam.getDescription()+"' , '"+exam.getDate()+"' , "+exam.getTime()+")";
			st.executeUpdate(sql);
			st.close();
			result = "succes";
			
		}catch(Exception e) {
			result = "error: "+e;
		}
		
		return result;
		
	}
	
	public ArrayList<Exam> getAll(){
		ConnectDB con = new ConnectDB();
		ArrayList<Exam> listExams = new ArrayList<>();
		try {
			Statement st = con.connect().createStatement();
			String sql = "SELECT * FROM exam";
			ResultSet resultQuery = st.executeQuery(sql);
			while(resultQuery.next()) {
				int key = Integer.parseInt(resultQuery.getString("key"));
				String description = resultQuery.getString("description");
				String date = resultQuery.getString("date");
				int time = Integer.parseInt(resultQuery.getString("time"));
				
				Exam exam = new Exam();
				exam.setKey(key);
				exam.setDescription(description);
				exam.setDate(date);
				exam.setTime(time);
				
				listExams.add(exam);
			}
		}catch(Exception e){
			System.out.println("Error: "+e);
		}

		return listExams;
	}
}
