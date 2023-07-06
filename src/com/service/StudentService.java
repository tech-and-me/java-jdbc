package com.service;

import java.util.List;

import com.dto.StudentDTO;
import com.exception.DuplicateIdException;
import com.exception.PersistenceException;
import com.exception.StudentNotFoundException;
import com.exception.ValidationException;

public interface StudentService {
	void createStudent(StudentDTO stu) throws DuplicateIdException,ValidationException,PersistenceException;
	List<StudentDTO> getAllStudents();
	StudentDTO getStudent(int id) throws StudentNotFoundException;
	void updateStudent(StudentDTO stu);
	void deleteStudent(int id);
	




}
