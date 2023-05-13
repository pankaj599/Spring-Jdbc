package com.spring.jdbc.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.spring.jdbc.entity.Student;

public class StudentRowmapper implements RowMapper<Student> {
	
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {

		Student st=new Student();
		st.setSid(rs.getInt(1));
		st.setSname(rs.getString(2));
		st.setSphone(rs.getString(3));
		st.setScity(rs.getString(4));
		
	return st;
}
	

}
