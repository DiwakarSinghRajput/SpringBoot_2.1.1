package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.StudentDao;
import com.example.demo.dto.StudentDTO;
import com.example.demo.models.Student;
import com.example.demo.service.StudentService;

@Service
@Transactional(readOnly = true)
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDao studentDao;

	@Override
	@Transactional(readOnly = false)
	public StudentDTO createOrUpdate(StudentDTO studentDTO) {
		Student student = new Student();
		try {
			String studentId = studentDTO.getStudentId();

			int size = studentDao.findAll().size();
			size = size + 1;

			if (studentId == null) {
				// Save New Row
				student.setStudentId("" + size);

				studentDTO.setStudentId("" + size);

			} else {
				// Edit old row
				student = studentDao.findById(studentId);
				studentDTO.setStudentId(student.getStudentId());
			}
			student.setStudentName(studentDTO.getStudentName());
			student.setRollNo(studentDTO.getRollNo());

			studentDao.saveOrUpdate(student);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return studentDTO;
	}

	@Override
	public StudentDTO getById(String studentId) {
		StudentDTO dto = new StudentDTO();
		try {
			Student student = studentDao.findById(studentId);

			dto.setStudentId(student.getStudentId());
			dto.setStudentName(student.getStudentName());
			dto.setRollNo(student.getRollNo());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return dto;
	}

	@Override
	public List<StudentDTO> getAll() {

		List<StudentDTO> dtoList = new ArrayList<>();
		try {

			List<Student> studentList = studentDao.findAll();

			for (Student student : studentList) {
				StudentDTO dto = new StudentDTO();
				dto.setStudentId(student.getStudentId());
				dto.setStudentName(student.getStudentName());
				dto.setRollNo(student.getRollNo());
				dtoList.add(dto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtoList;
	}

	@Override
	@Transactional(readOnly = false)
	public boolean deleteById(String studentId) {
		try {
			studentDao.deleteById(Student.class, studentId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

}
