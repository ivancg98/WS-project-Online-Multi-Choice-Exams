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
			String sql = "INSERT INTO client (key, examkey, grade, hasgrade) VALUES('"+client.getKey()+"',"+client.getExamKey()+","+client.getGrade()+","+Boolean.toString(client.getHasGrade())+");";
			st.executeUpdate(sql);
			st.close();

		} catch (Exception e) {
			System.out.println("ERROR:" + e);
			return false;
		}

		con.disconnect();
		return true;

	}

	public boolean uploadGrade(Client client, float grade) {
		ConnectDB con = new ConnectDB();
		String gradeStr = String.valueOf(grade);

		try {
			Statement st = con.connect().createStatement();
			String sql = "UPDATE client SET grade = " + gradeStr + " AND hasgrade = TRUE WHERE key = '" + client.getKey() + "' AND examkey = " + client.getExamKey() + ";";
			st.executeUpdate(sql);
			
			st.close();
		} catch (Exception e) {
			System.out.println("ERROR:" + e);
			return false;
		}
		con.disconnect();
		return true;

	}

	public ArrayList<Client> getListClientsOfExam(int k) {
		ConnectDB con = new ConnectDB();
		ArrayList<Client> listClientsOfExam = new ArrayList<>();

		try {
			Statement st = con.connect().createStatement();
			String sql = "SELECT * FROM client WHERE examkey = " + k + ";";
			ResultSet resultQuery = st.executeQuery(sql);
			while (resultQuery.next()) {
				String key = resultQuery.getString("key");
				int examKey = Integer.parseInt(resultQuery.getString("examkey"));
				float grade = Float.parseFloat(resultQuery.getString("grade"));
				boolean hasGrade = Boolean.valueOf(resultQuery.getString("hasgrade"));
				Client client = new Client(key, examKey, grade, hasGrade);
				listClientsOfExam.add(client);
			}
			
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
		con.disconnect();
		return listClientsOfExam;
	}

	public ArrayList<Client> getListClientsAllExams() {
		ConnectDB con = new ConnectDB();
		ArrayList<Client> listClientsAllExams = new ArrayList<>();

		try {
			Statement st = con.connect().createStatement();
			String sql = "SELECT * FROM client ;";
			ResultSet resultQuery = st.executeQuery(sql);
			while (resultQuery.next()) {
				String key = resultQuery.getString("key");
				int examKey = Integer.parseInt(resultQuery.getString("examkey"));
				float grade = Float.parseFloat(resultQuery.getString("grade"));
				boolean hasGrade = Boolean.valueOf(resultQuery.getString("hasgrade"));
				Client client = new Client(key, examKey, grade, hasGrade);
				listClientsAllExams.add(client);
			}
			
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
		con.disconnect();
		return listClientsAllExams;
	}

	public ArrayList<Client> getListGradesOfClient(String k) {
		ConnectDB con = new ConnectDB();
		ArrayList<Client> listGradesOfClient = new ArrayList<>();

		try {
			Statement st = con.connect().createStatement();
			String sql = "SELECT * FROM client WHERE key = '" + k + "';";
			ResultSet resultQuery = st.executeQuery(sql);
			while (resultQuery.next()) {
				String key = resultQuery.getString("key");
				int examKey = Integer.parseInt(resultQuery.getString("examkey"));
				float grade = Float.parseFloat(resultQuery.getString("grade"));
				boolean hasGrade = Boolean.valueOf(resultQuery.getString("hasgrade"));
				Client client = new Client(key, examKey, grade, hasGrade);
				listGradesOfClient.add(client);
			}
			
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
		con.disconnect();
		return listGradesOfClient;
	}

	public boolean hasExamGrades(int key) {
		ConnectDB con = new ConnectDB();
		boolean hasGrades;

		try {
			Statement st = con.connect().createStatement();
			String sql = "SELECT * FROM client WHERE examkey = '" + key + "' AND hasgrade = TRUE;";
			hasGrades = st.execute(sql);

		} catch (Exception e) {
			System.out.println("Error: " + e);
			return false;
		}
		con.disconnect();
		return hasGrades;
	}
	
	public boolean hasClient(Client client) {
		ConnectDB con = new ConnectDB();
		boolean hasExist;

		try {
			Statement st = con.connect().createStatement();
			String sql = "SELECT * FROM client WHERE key = '" + client.getKey() + "' AND examKey = " + client.getExamKey() + ";";
			hasExist = st.execute(sql);

		} catch (Exception e) {
			System.out.println("Error: " + e);
			return false;
		}
		con.disconnect();
		return hasExist;
	}
	


}
