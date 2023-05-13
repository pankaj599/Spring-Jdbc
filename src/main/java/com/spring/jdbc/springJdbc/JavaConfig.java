package com.spring.jdbc.springJdbc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.spring.jdbc.Dao.StudentDaoimpl;

//IF WORKING WITHOU XML THAN THIS HOW TO DO CONFIGURATION ELSE USE NORMAL XML

@Configuration
public class JavaConfig {
	@Bean
 public DriverManagerDataSource getdataSource()
 {
	 DriverManagerDataSource driverBhai=new DriverManagerDataSource();
	 driverBhai.setDriverClassName("com.mysql.cj.jdbc.Driver");
	 driverBhai.setUrl("jdbc:mysql://localhost:3306/student_manager");
	 driverBhai.setUsername("root");
	 driverBhai.setPassword("admin");
	return driverBhai;
	 
 }

	@Bean
	public JdbcTemplate temp(){
		JdbcTemplate j= new JdbcTemplate();
		j.setDataSource(getdataSource());
		return j;
	}
	
	@Bean("hmmm")
	public StudentDaoimpl st()
	{
		StudentDaoimpl student=new StudentDaoimpl();
		student.setTemp(temp());
		return student;
	}
}
