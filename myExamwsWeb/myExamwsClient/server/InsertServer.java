package server;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;

import entities.Server;

public class InsertServer {
	
	public InsertServer() {
		
	}
	public static void main(Server server){ 
		try {
			URL url = new URL("http://localhost:8080/myExamwsWeb/rest/server");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setDoOutput(true);
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Content-Type", "application/json");
			
			Gson gson = new Gson();
			System.out.println("The server to be inserted: "+gson.toJson(server));
			OutputStream out = connection.getOutputStream();
			out.write(gson.toJson(server ).getBytes());
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
