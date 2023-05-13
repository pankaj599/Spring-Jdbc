package com.spring.jdbc.springJdbc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.Dao.StudentDaoimpl;
import com.spring.jdbc.entity.Student;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main( String[] args ) throws NumberFormatException, IOException
	{
		//ApplicationContext context=new ClassPathXmlApplicationContext("com/spring/jdbc/springJdbc/config.xml");
		ApplicationContext context= new AnnotationConfigApplicationContext(JavaConfig.class);
		//        JdbcTemplate temp=context.getBean("JdbcTemplateRakhRaha",JdbcTemplate.class);
		//        
		//        //CREATE QUERY
		//        String query="Insert into student_data(sname, sphone, scity) Values(?,?,?)";
		//        
		//        //FIRE QUERY
		//        int update = temp.update(query, "pankaj", "5647998123", "gandhinagar");
		//        System.out.println(update);
		//							OR

		//     M-2
		StudentDaoimpl s=context.getBean("hmmm",StudentDaoimpl.class);
		while(true)
		{
			BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
			System.out.println("press 1 to insert");
			System.out.println("press 2 to delete");
			System.out.println("press 3 to update");
			System.out.println("press 4 to display");
			System.out.println("press 5 to displayAllData");
			System.out.println("press 6 to exit");
			int c=Integer.parseInt(br.readLine());
			if(c==1)
			{
				//ADD

				System.out.println("enter name");
				String name=br.readLine();

				System.out.println("enter phone");
				String phone=br.readLine();

				System.out.println("enter city");
				String city= br.readLine();

				Student st= new Student(name, phone, city);

				int ins = s.insert(st);
				if(ins>0)
				{
					System.out.println("SUCCESSFULLY INSERTED");
				}
				else
					System.out.println("FAILURE IN INSERTION");

			}
			else if(c==2)
			{
				//DELETE
				System.out.println("enter id no to delete");
				int id=Integer.parseInt(br.readLine());
				s.delete(id);

			}
			else if(c==3)
			{
				System.out.println("enter the id to update");
				int id= Integer.parseInt(br.readLine());
				System.out.println("enter new name");
				String x=br.readLine();
				Student st=new Student(id, x);
				int update = s.update(st);
				if(update>0)
					System.out.println("SUCCESSFULLY UPDATED");
				else
					System.out.println("FAILED TO UPDATE");

			}
			else if(c==4)
			{
				System.out.println("enter the id to display its data");
				int id=Integer.parseInt(br.readLine());
				Student display = s.display(id);
				System.out.println(display);
			}
			else if(c==5)
			{
				System.out.println("DISPLAY ALL THE DATA");
				List<Student> st=s.displayAll();
				//System.out.println(st);
				for(Student sp: st)
					System.out.println(sp);

			}
			else if(c==6)
			{
				break;
			}
		}
		System.out.println("bye bye");
		//        Student student=new Student("bhalu","123458976","jungle");
		//        Student st=new Student();
		//        st.setSname("Lion");
		//        st.setSid(4);
		//        int p = s.insert(student);
		//        int x=s.update(st);
		//        System.out.println(student+" "+p);
		//        System.out.println(st+" "+x);
		//s.delete(5);


	}
}
