package exam;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;



import com.google.gson.Gson;

import entities.Exam;


public class InsertExam {
	
	public InsertExam() {
		
	}
	
	public static void main(Exam exam){ 
	try {
		URL url = new URL("http://localhost:8080/myExamwsWeb/rest/exam");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setDoOutput(true);
		connection.setRequestMethod("POST");
		connection.setRequestProperty("Content-Type", "application/json");
		
	
		Gson gson = new Gson();
		System.out.println("The exam to be inserted: "+gson.toJson(exam));
		OutputStream out = connection.getOutputStream();
		out.write(gson.toJson(exam).getBytes());
		out.flush();
		
		
		if(connection.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
			throw new RuntimeException("ERROR: " + connection.getResponseCode());
		}
		
		System.out.println("SUCCESS: " + connection.getResponseCode());
		connection.disconnect();
		
	}catch(IOException e) {
		System.out.println("Error: "+e);
	}
}

}
