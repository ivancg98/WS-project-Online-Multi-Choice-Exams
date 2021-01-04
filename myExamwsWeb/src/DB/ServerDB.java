package DB;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import entities.Exam;
import entities.Server;

public class ServerDB {
	
	public boolean insertServer(Server server) {
		ConnectDB con = new ConnectDB();
		
		try {
			Statement st = con.connect().createStatement();
			String sql = "INSERT INTO server (ip, port) VALUES('"+server.getIp()+"' , '"+server.getPort()+"');";
			st.executeUpdate(sql);
			st.close();
			
		}catch(Exception e) {
			System.out.println("ERROR:"+e);
			return false;
		}
		
		con.disconnect();
		return true;
		
	}
	
	
	public ArrayList<Server> getAllServers(){
		ConnectDB con = new ConnectDB();
		ArrayList<Server> listServers = new ArrayList<>();
		
		try {
			Statement st = con.connect().createStatement();
			String sql = "SELECT * FROM server;";
			ResultSet resultQuery = st.executeQuery(sql);
			while(resultQuery.next()) {
				int key = Integer.parseInt(resultQuery.getString("key"));
				String ip = resultQuery.getString("ip");
				String port = resultQuery.getString("port");
						
				Server server = new Server(key, ip, port);	
				listServers.add(server);
			}
			
		}catch(Exception e){
			System.out.println("Error: "+e);
		}

		con.disconnect();
		return listServers;
	}
	
	public Server getServerFromKey(int k) {
		ConnectDB con = new ConnectDB();
		Server  server = new Server();
		
		try {
			Statement st = con.connect().createStatement();
			String sql = "SELECT * FROM server WHERE key = "+k+";";
			ResultSet resultQuery = st.executeQuery(sql);
			if(resultQuery.next()) {
				int key = Integer.parseInt(resultQuery.getString("key"));
				String ip = resultQuery.getString("ip");
				String port = resultQuery.getString("port");
			
				server.setKey(key);
				server.setIp(ip);
				server.setPort(port);

			}
			
		}catch(Exception e){
			System.out.println("Error: "+e);
		}
		

		con.disconnect();
		return server;
	}



public Server getServerFromIpPort(String i, String p) {
	ConnectDB con = new ConnectDB();
	Server  server = new Server();
	
	try {
		Statement st = con.connect().createStatement();
		String sql = "SELECT * FROM server WHERE port = '"+p+"' AND ip = '"+i+"';";
		ResultSet resultQuery = st.executeQuery(sql);
		if(resultQuery.next()) {
			int key = resultQuery.getInt("key");
			String ip = resultQuery.getString("ip");
			String port = resultQuery.getString("port");
		
			server.setKey(key);
			server.setIp(ip);
			server.setPort(port);

		}
		
	}catch(Exception e){
		System.out.println("Error: "+e);
	}
	

	con.disconnect();
	return server;
}


public boolean hasServer(int key) {
	ConnectDB con = new ConnectDB();
	boolean hasExist;

	try {
		Statement st = con.connect().createStatement();
		String sql = "SELECT * FROM server WHERE key = " + key + ";";
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
