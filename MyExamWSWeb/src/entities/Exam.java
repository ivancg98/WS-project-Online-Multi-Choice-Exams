package entities;

public class Exam {
	public int key;
	public String description;
	public String date;
	public String time;
	public int location;

	
	public Exam() {
		
	}
	
	public Exam(int key, String description, String date, String time, int location) {
		this.key = key;
		this.description = description;
		this.date = date;
		this.time = time;
		this.location = location; 

	}
	
	public Exam(String description, String date, String time, int location) {
		this.description = description;
		this.date = date;
		this.time = time;
		this.location = location;
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
	
	public void setTime(String time) {
		this.time = time;
	}
	
	public void setLocation(int serverkey) {
		this.location = serverkey;
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
	
	public String getTime() {
		return this.time;
	}
	
	public int getLocation() {
		return this.location;
	}
	
}
