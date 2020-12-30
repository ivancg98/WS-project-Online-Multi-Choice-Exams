package myExamwsClient;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;

import entities.Exam;

public class DeleteExam {
	public static void main(String[] args){ 
	try {
		URL url = new URL("http://localhost:8080/myExamwsWeb/rest/exam/14");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setDoOutput(true);
		connection.setRequestMethod("DELETE");
			
		System.out.println("CODE: " + connection.getResponseCode());
		connection.disconnect();
		
	}catch(IOException e) {
		System.out.println("Error: "+e);
	}

}
}
