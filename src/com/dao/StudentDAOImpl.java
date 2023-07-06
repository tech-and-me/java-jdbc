package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dto.StudentDTO;

public class StudentDAOImpl implements StudentDAO {

	public Connection openConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");//Register myslq Type-4 driver with DriverManager
			System.out.println("MYSQL driver registred with DriverManager");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3307/stu","root","root");
			System.out.println(con);
		} catch (ClassNotFoundException e) {
			System.out.println("MYSQL suitable driver not found");
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	
	public void closeConnection(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//JDBC API code in order to connect to underlying storage
	@Override
	public void create(StudentDTO student) {
		
		int id = student.getId();
		String fname = student.getFname();
		String lname = student.getLname();
		
		Connection con = openConnection();
		try {
//			Statement stat = con.createStatement();
//			String sql = "INSERT INTO student (id, fname, lname) VALUES (" + id + ", '" + fname + "', '" + lname + "');";
//			int n = stat.executeUpdate(sql);
			
			String sql = "INSERT INTO student (id,fname,lname) VALUES (?,?,?)";		
			PreparedStatement pstat = con.prepareStatement(sql);
			pstat.setInt(1, id);
			pstat.setString(2, fname);
			pstat.setString(3, lname);
			int n = pstat.executeUpdate();
			
			System.out.println("Number of rows inserted: " + n);
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
		closeConnection(con);
	}

	@Override
	public List<StudentDTO> retrieveAll() {
		List<StudentDTO> students = new ArrayList<>();
		Connection con = openConnection();
		
		String sql = "SELECT * FROM student;";
		Statement stat;
		try {
			stat = con.createStatement();
			ResultSet rs = stat.executeQuery(sql); // this would return a list of students
			
			while(rs.next()) { // looping through resultset (of students list received)
				int id = rs.getInt("id");
				String fname = rs.getString("fname");
				String lname = rs.getString("lname");
				
				StudentDTO student = new StudentDTO(id,fname,lname);
				students.add(student);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		closeConnection(con);
		return students;
	}

	@Override
	public StudentDTO retrieve(int id) {
		Connection con = openConnection();
		String sql = "SELECT * FROM student WHERE id = ?";
		
		StudentDTO student = null;
		
		try {
			PreparedStatement pstat = con.prepareStatement(sql);
			pstat.setInt(1,id);
			
			ResultSet rs = pstat.executeQuery();  // this would return a list of students (even though just 1 student is return)
			
			while(rs.next()) {
				int stuId = rs.getInt("id");
				String fname = rs.getString("fname");
				String lname = rs.getString("lname");
				student = new StudentDTO(id,fname,lname);				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		closeConnection(con);
		
		
		return student;
	}

	@Override
	public void update(StudentDTO stu) {

	}

	@Override
	public void delete(int id) {

	}

}
