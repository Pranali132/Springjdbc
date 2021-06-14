package com.spring.jdbc;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.entities.Student;



public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "My Program Started" );
        //Spring jdbc =>JdbcTemplate
        ApplicationContext context=new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");
       StudentDao studentDao=(StudentDao) context.getBean("studentDao");
       //Inserting the query
       // Student student=new Student();
       // student.setId(666);
      //  student.setName("John");
      //  student.setCity("Lucknow");
      // int result= studentDao.insert(student);
     //  System.out.println("student added"+result);
     //updating the query  
       // Student student=new Student();
        //student.setId(245);
        //student.setName("Raj kumar");
        //student.setCity("Mumbai");
        //int result = studentDao.change(student);
        //System.out.println("data changed"+result);
        //Deleting the Query
    // int result=studentDao.delete(245);
    // System.out.println("Deleted" + result);
       //Executing a single row
    // Student student=studentDao.getStudent(456);
     //System.out.println(student);
       //Executing multiple row
      List<Student> students=studentDao.getAllStudents();
      for(Student s:students) {
    	  System.out.println(s);
      }

       
       
    }
      
}
