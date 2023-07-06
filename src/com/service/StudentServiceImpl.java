package com.service;

import java.util.List;

import com.dao.StudentDAO;
import com.dao.StudentDAOImpl;
import com.dto.StudentDTO;
import com.exception.DuplicateIdException;
import com.exception.PersistenceException;
import com.exception.StudentNotFoundException;
import com.exception.ValidationException;

public class StudentServiceImpl implements StudentService {

	private StudentDAO dao;
	
	public StudentServiceImpl() {
		dao = new StudentDAOImpl();
	}
	
	
	@Override
	public void createStudent(StudentDTO student) 
	throws DuplicateIdException, ValidationException, PersistenceException{
		dao.create(student);

	}

	@Override
	public List<StudentDTO> getAllStudents() {
		List<StudentDTO> students = dao.retrieveAll();
		return students;
	}

	@Override
	public StudentDTO getStudent(int id) throws StudentNotFoundException {
		StudentDTO student = dao.retrieve(id);
		if(student == null) {
			throw new StudentNotFoundException();
		}
		return student;
	}

	@Override
	public void updateStudent(StudentDTO stu) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteStudent(int id) {
		// TODO Auto-generated method stub

	}
}
