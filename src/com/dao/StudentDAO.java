package com.dao;

import java.util.List;

import com.dto.StudentDTO;

public interface StudentDAO {
	void create(StudentDTO student);
	List<StudentDTO> retrieveAll();
	StudentDTO retrieve(int id);
	void update(StudentDTO stu);
	void delete(int id);
	
	
}
