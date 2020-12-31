package DB;

import java.sql.Statement;

import entities.Server;

public class ServerDB {
	
	public boolean insertServer(Server server) {
		ConnectDB con = new ConnectDB();
		
		try {
			Statement st = con.connect().createStatement();
			String sql = "INSERT INTO server (Ip, Port) VALUES("+server.getIp()+" , "+server.getPort()+");";
			st.executeUpdate(sql);
			st.close();
			
			
		}catch(Exception e) {
			System.out.println("ERROR:"+e);
			return false;
		}
		
		con.disconnect();
		return true;
		
	}

}
