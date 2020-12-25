package resources;

public class Exam {
	public int key;
	public String description;
	public String date;
	public int time;
	public int serverKey;
	public int clientKey;
	
	public Exam() {
		
	}
	
	public Exam(int key, String description, String date, int time, int serverKey, int clientKey) {
		this.key = key;
		this.description = description;
		this.date = date;
		this.time = time;
		this.serverKey = serverKey;
		this.clientKey = clientKey;
	}
	
	public Exam(String description, String date, int time, int serverKey, int clientKey) {
		this.description = description;
		this.date = date;
		this.time = time;
		this.serverKey = serverKey;
		this.clientKey = clientKey;
	}
	
	public void setKey(int key) {
		this.key = key;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public void setTime(int time) {
		this.time = time;
	}
	
	public void setServerKey(int serverKey) {
		this.serverKey = serverKey;
	}
	
	public void setClientKey(int clientKey) {
		this.clientKey = clientKey;
	}
	
	public int getKey() {
		return this.key;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public String getDate() {
		return this.date;
	}
	
	public int getTime() {
		return this.time;
	}
	
	public int getServerKey() {
		return this.serverKey;
	}
	
	public int getClientKey() {
		return this.clientKey;
	}
	
	
}
	

