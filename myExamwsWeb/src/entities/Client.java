package entities;

public class Client {
	public String key;
	public int examKey;
	public String descriptionExam;
	public float grade;
	

	public Client() {
		
	}
	
	public Client(String key, int examKey, String descriptionExam, float grade) {
		this.key = key;
		this.examKey= examKey;
		this.descriptionExam = descriptionExam;
		this.grade = grade;
	}
	
	
	public void setKey(String key) {
		this.key = key;
	}
	
	public void setKeyExam(int examKey) {
		this.examKey = examKey;
	}
	
	public void setDescriptionExam(String descriptionExam) {
		this.descriptionExam = descriptionExam;
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
	
	public String getDescriptionExam() {
		return this.descriptionExam;
	}
	
	public float getGrade() {
		return this.grade;
	}
	
	
	
}