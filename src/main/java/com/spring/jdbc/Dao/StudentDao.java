package com.spring.jdbc.Dao;

import java.util.List;

import com.spring.jdbc.entity.Student;

public interface StudentDao {
	public int insert(Student student);
	public int update(Student student);
	public void delete(int i);
	public Student display(int id);
	public List<Student> displayAll();
}
