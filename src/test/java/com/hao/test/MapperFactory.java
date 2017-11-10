package com.hao.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.hao.myBatis.StudentMapper;
import com.hao.personnel.information.Student;
import com.hao.personnel.information.Teacher;

public class MapperFactory {

	public static SqlSession getSqlSession() throws IOException {
		String resource = "myBatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		return sqlSessionFactory.openSession();
	}
	
	

	public static <T> T getMapper(Class<T> cls) throws InstantiationException, IllegalAccessException {
		return cls.newInstance();
	}
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, IOException {

		SqlSession sqlSession = getSqlSession();
		StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
		Student student = new Student(null,"jerry", new Date(), true, "teacher0");
		mapper.add(student);
		sqlSession.close();
		System.out.println(student);

		System.out.println("-------------------------------------------------------------------------");
		
		Teacher pers = getMapper(Teacher.class);
		System.out.println(pers);
		
		System.out.println("-------------------------------------------------------------------------");
		
		Student student1 = Student.class.newInstance();
		student1.setBirth(new Date());
		System.out.println(student1.getBirth().toString());
		
		System.out.println("-------------------------------------------------------------------------");
		
		lable:
		{
			lable2:
			for(int i=0;i<10;i++) {
				if(i==5)break lable;
				System.out.println(i);
			}
			System.out.println("Y");
		}
	}
	
}
