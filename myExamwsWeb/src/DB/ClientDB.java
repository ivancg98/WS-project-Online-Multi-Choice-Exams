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
			String sql = "INSERT INTO client (key, examkey, grade, hasgrade) VALUES('" + client.getKey() + "',"
					+ client.getExamKey() + "," + client.getGrade() + "," + Boolean.toString(client.getHasGrade())
					+ ");";
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
			String sql = "UPDATE client SET grade = " + gradeStr + ", hasgrade = TRUE WHERE key = '" + client.getKey()
					+ "' AND examkey = " + client.getExamKey() + ";";
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
				int examKey = resultQuery.getInt("examkey");
				float grade = resultQuery.getFloat("grade");
				boolean hasGrade = resultQuery.getBoolean("hasgrade");
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
				int examKey = resultQuery.getInt("examkey");
				float grade = resultQuery.getFloat("grade");
				boolean hasGrade = resultQuery.getBoolean("hasgrade");
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
				int examKey = resultQuery.getInt("examkey");
				float grade = resultQuery.getFloat("grade");
				boolean hasGrade = resultQuery.getBoolean("hasgrade");
				Client client = new Client(key, examKey, grade, hasGrade);
				listGradesOfClient.add(client);
			}

		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
		con.disconnect();
		return listGradesOfClient;
	}

	public boolean hasExam(int key) {
		ConnectDB con = new ConnectDB();
		boolean hasExist;

		try {
			Statement st = con.connect().createStatement();
			String sql = "SELECT * FROM exam WHERE key = " + key + ";";
			ResultSet resultQuery = st.executeQuery(sql);
			hasExist = resultQuery.next();

		} catch (Exception e) {
			System.out.println("Error: " + e);
			return false;
		}
		con.disconnect();
		return hasExist;
	}

	public boolean hasClient(Client client) {
		ConnectDB con = new ConnectDB();
		boolean hasExist;

		try {
			Statement st = con.connect().createStatement();
			String sql = "SELECT * FROM client WHERE key = '" + client.getKey() + "' AND examKey = "
					+ client.getExamKey() + ";";
			ResultSet resultQuery = st.executeQuery(sql);
			hasExist = resultQuery.next();

		} catch (Exception e) {
			System.out.println("Error: " + e);
			return false;
		}
		con.disconnect();
		return hasExist;
	}

}
