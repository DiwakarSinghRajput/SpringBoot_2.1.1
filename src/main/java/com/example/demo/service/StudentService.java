package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.StudentDTO;

public interface StudentService {

	StudentDTO createOrUpdate(StudentDTO studentDTO);

	StudentDTO getById(String studentId);

	List<StudentDTO> getAll();

	boolean deleteById(String studentId);
}
