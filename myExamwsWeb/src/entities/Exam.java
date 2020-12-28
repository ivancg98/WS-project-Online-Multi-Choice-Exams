package entities;

public class Exam {
	public int key;
	public String description;
	public String date;
	public int time;

	
	public Exam() {
		
	}
	
	public Exam(int key, String description, String date, int time) {
		this.key = key;
		this.description = description;
		this.date = date;
		this.time = time;

	}
	
	public Exam(String description, String date, int time) {
		this.description = description;
		this.date = date;
		this.time = time;

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
	
}
	

