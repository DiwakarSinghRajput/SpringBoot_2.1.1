package com.example.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student", catalog = "demo")
public class Student {

	private String studentId;
	private String studentName;
	private String rollNo;

	@Id
	@Column(name = "stu_id", unique = true, nullable = false, length = 255)
	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	@Column(name = "stu_name", length = 255)
	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	@Column(name = "roll_no", length = 255)
	public String getRollNo() {
		return rollNo;
	}

	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}

}
