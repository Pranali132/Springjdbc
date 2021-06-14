package com.spring.jdbc.dao;
import com.spring.jdbc.entities.Student;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;



public class StudentDaoImpl implements StudentDao {
	private JdbcTemplate jdbcTemplate;
	public int insert(Student student) {
	      //insert query
	    String query="insert into student(id,name,city) values(?,?,?)";
        int r=  this.jdbcTemplate.update(query,student.getId(),student.getName(),student.getCity());
		return r;
	}
	public int change(Student student) {
		// updating data
		String query="update student set name=?, city=? where id=?";
		int r = this.jdbcTemplate.update(query,student.getName(),student.getCity(),student.getId());
		return r;
	}
	public int delete(int studentId) {
		//deleting query
		String query="delete from student where id=?";
		int r = this.jdbcTemplate.update(query,studentId);
        return r;
	}
	//selecting single student data
	public Student getStudent(int studentId) {
		String query="select * from student where id=?";
		RowMapper<Student > rowMapper=new RowMapperImpl();
		Student student=this.jdbcTemplate.queryForObject(query, rowMapper,studentId);
		return student;
	}
	//Selecting Multiple student data
	public List<Student> getAllStudents() {
		String query="select * from student";
		List<Student> students=this.jdbcTemplate.query(query,new RowMapperImpl());

		return students;
	}



	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}


	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


	

}
