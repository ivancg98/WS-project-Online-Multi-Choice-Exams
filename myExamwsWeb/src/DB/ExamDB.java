package DB;

import entities.Exam;
import java.sql.*;

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
}
