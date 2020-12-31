package entities;

public class Client {
	public String key;
	public int examKey;
	public float grade;
	

	public Client() {
		
	}
	
	public Client(String key, int examKey, float grade) {
		this.key = key;
		this.examKey= examKey;
		this.grade = grade;
	}
	
	
	public void setKey(String key) {
		this.key = key;
	}
	
	public void setKeyExam(int examKey) {
		this.examKey = examKey;
	}
		
	public void setGrade(float grade) {
		this.grade = grade;
	}
	
	public String getKey() {
		return this.key;
	}
	
	public int getExamKey() {
		return this.examKey;
	}
	
	public float getGrade() {
		return this.grade;
	}
	
	
	
}