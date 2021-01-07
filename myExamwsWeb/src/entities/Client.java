package entities;

public class Client {
	public String key;
	public int examKey;
	public float grade;
	public boolean hasGrade;

	public Client() {

	}

	public Client(String key, int examKey, float grade, boolean hasGrade) {
		this.key = key;
		this.examKey = examKey;
		this.grade = grade;
		this.hasGrade = hasGrade;
	}

	public Client(String key, int examKey) {
		this.key = key;
		this.examKey = examKey;
		this.grade = 0.0f;
		this.hasGrade = false;

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

	public void setHasGrade(boolean hasGrade) {
		this.hasGrade = hasGrade;
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

	public boolean getHasGrade() {
		return this.hasGrade;
	}

}