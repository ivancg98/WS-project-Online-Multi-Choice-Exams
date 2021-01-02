package myExamwsClient;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;

import entities.Exam;

public class UpdateExam {

	public static void main(String[] args){ 
		try {
			URL url = new URL("http://localhost:8080/MyExamWSWeb/rest/exam/3");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setDoOutput(true);
			connection.setRequestMethod("PUT");
			connection.setRequestProperty("Content-Type", "application/json");
			
			Exam exam = new Exam(3, "webs molona","30/12/2020","13:00", 1);
			Gson gson = new Gson();
			System.out.println("The exam to be updated: "+gson.toJson(exam));
			OutputStream out = connection.getOutputStream();
			out.write(gson.toJson(exam).getBytes());
			out.flush();
			
			
			System.out.println("SUCCESS: " + connection.getResponseCode());
			connection.disconnect();
			
		}catch(IOException e) {
			System.out.println("Error: "+e);
		}
	}
}
