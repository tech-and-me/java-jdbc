package com.controller;

import java.util.List;

import com.dto.StudentDTO;
import com.exception.DuplicateIdException;
import com.exception.PersistenceException;
import com.exception.StudentNotFoundException;
import com.exception.ValidationException;
import com.service.StudentService;
import com.service.StudentServiceImpl;

public class Controller {

	//Controller -> Service Layer -> Data Access Object -> Storage (Eg: Oracle or MySql)
	
	public static void main(String[] args) {
		StudentService service = new StudentServiceImpl();
		
		StudentDTO student = null;
		int searchId = 15;
		try {
			student = service.getStudent(searchId);
			System.out.println(student);
		} catch (StudentNotFoundException e) {
			System.out.println("Student with ID: " + searchId + " is not found");
		}
		
		
		
		/*
		StudentDTO student = new StudentDTO(14,"Jack","Newton");
		StudentDTO student1 = new StudentDTO(15,"Thomas","Tong");
		StudentDTO student2 = new StudentDTO(16,"Bella","Hopkin");
		
		List<StudentDTO> students = service.getAllStudents();
		
		for(StudentDTO stu:students) {
			System.out.println(stu);
		}
		
		*/
		
		/*
		try {
			service.createStudent(student);
		} catch (DuplicateIdException e) {
			e.printStackTrace();
		} catch (ValidationException e) {
			e.printStackTrace();
		} catch (PersistenceException e) {
			e.printStackTrace();
		}
		*/
		
		
	}

}
