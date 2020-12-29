package entities;

public class Student {

	private int key;
	private String studentId;
	
	public Student(String studentId) {
		this.setStudentId(studentId);
	}
	
	public Student(int key, String studentId) {
		this.setKey(key);
		this.setStudentId(studentId);
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	
	
}
