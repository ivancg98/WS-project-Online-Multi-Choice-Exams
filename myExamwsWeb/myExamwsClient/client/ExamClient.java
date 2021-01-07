package client;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;

import DB.ExamDB;
import entities.Exam;

public class ExamClient {

	public ExamClient() {

	}

	public static void insertExam(Exam exam) {
		try {
			URL url = new URL("http://localhost:8080/myExamwsWeb/rest/exam");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setDoOutput(true);
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Content-Type", "application/json");

			Gson gson = new Gson();
			System.out.println("The exam to be inserted: " + gson.toJson(exam));
			OutputStream out = connection.getOutputStream();
			out.write(gson.toJson(exam).getBytes());
			out.flush();

			if (connection.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
				throw new RuntimeException("ERROR: " + connection.getResponseCode());
			}

			System.out.println("SUCCESS: " + connection.getResponseCode());
			connection.disconnect();

		} catch (IOException e) {
			System.out.println("Error: " + e);
		}
	}

	public static void deleteExam(int key) {
		try {
			String keyStr = String.valueOf(key);
			URL url = new URL("http://localhost:8080/myExamwsWeb/rest/exam/" + keyStr);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setDoOutput(true);
			connection.setRequestMethod("DELETE");

			System.out.println("CODE: " + connection.getResponseCode());
			connection.disconnect();

		} catch (IOException e) {
			System.out.println("Error: " + e);
		}

	}

	public static void modifyExamDescription(int key, String description) {
		try {
			String keyStr = String.valueOf(key);
			URL url = new URL("http://localhost:8080/myExamwsWeb/rest/exam/" + keyStr);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setDoOutput(true);
			connection.setRequestMethod("PUT");
			connection.setRequestProperty("Content-Type", "application/json");

			Gson gson = new Gson();
			ExamDB examdb = new ExamDB();
			Exam exam = examdb.getExamFromKey(key);
			exam.setDescription(description);

			System.out.println("The description to be modified: " + gson.toJson(exam.getDescription()));
			OutputStream out = connection.getOutputStream();
			out.write(gson.toJson(exam).getBytes());
			out.flush();

			System.out.println("CODE: " + connection.getResponseCode());
			connection.disconnect();

		} catch (IOException e) {
			System.out.println("Error: " + e);
		}
	}
}
