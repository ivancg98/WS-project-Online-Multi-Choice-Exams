package client;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;

import entities.Client;

public class InsertClient {
	public static void main(String[] args){ 
	try {
		URL url = new URL("http://localhost:8080/myExamwsWeb/rest/client");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setDoOutput(true);
		connection.setRequestMethod("POST");
		connection.setRequestProperty("Content-Type", "application/json");
		
		Client client = new Client("47489Y",1);
		Gson gson = new Gson();
		System.out.println("The client to be inserted: " + gson.toJson(client));
		OutputStream out = connection.getOutputStream();
		out.write(gson.toJson(client).getBytes());
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
