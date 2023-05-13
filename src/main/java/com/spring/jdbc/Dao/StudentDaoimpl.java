package com.spring.jdbc.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.spring.jdbc.entity.Student;

public class StudentDaoimpl implements StudentDao{

	//@Autowired
	private JdbcTemplate temp;

	public JdbcTemplate getTemp() {
		return temp;
	}

	public void setTemp(JdbcTemplate temp) {
		this.temp = temp;
	}

	public int insert(Student student) {
		// TODO Auto-generated method stub
		String query="Insert into student_data(sname, sphone, scity) Values(?,?,?)";

		int i = temp.update(query,student.getSname(),student.getSphone(),student.getScity());

		return i;
	}

	public int update(Student student) {
		// TODO Auto-generated method stub
		String query="update student_data set sname=? where sid=?";
		int u = temp.update(query,student.getSname(), student.getSid());
		return u;
	}

	public void delete(int i) {
		// TODO Auto-generated method stub
		String del=" Delete from student_data where sid=?";
		int dele = this.temp.update(del,i);
		if(dele>0)
			System.out.println("DELETED SUCCESSFULLY");
		else
			System.out.println("UNABLE TO DELETE");
	}

	public Student display(int id) {

		String query="Select * from student_data where sid=?";

		//PARENT CHILD KA OBJECT BANA SAKTA HAI
		RowMapper<Student> rowMapper=new StudentRowmapper();
		Student queryForObject = this.temp.queryForObject(query, rowMapper, id);
		return queryForObject;
		// TODO Auto-generated method stub


	}

	public List<Student> displayAll() {
		String query="Select * from student_data";
		RowMapper<Student> rM=new StudentRowmapper();
		
		List<Student> query2 = this.temp.query(query, rM);
		return query2;
		// TODO Auto-generated method stub

	}

}
