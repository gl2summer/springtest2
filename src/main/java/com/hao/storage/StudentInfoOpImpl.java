package com.hao.storage;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.hao.myBatis.MapperFactory;
import com.hao.myBatis.StudentMapper;
import com.hao.personnel.information.Student;

public class StudentInfoOpImpl implements StudentInfoOp {

	public synchronized void add(Student student) {
		// TODO Auto-generated method stub
		try {
			SqlSession session = MapperFactory.getSqlSession();
			StudentMapper studentMapper = session.getMapper(StudentMapper.class);
			studentMapper.add(student);
			session.commit();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public synchronized void list() {
		// TODO Auto-generated method stub
		SqlSession session;
		try {
			session = MapperFactory.getSqlSession();
			StudentMapper studentMapper = session.getMapper(StudentMapper.class);
			List<Student> list = studentMapper.list();
			for (Student student : list) {
				System.out.println(student);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
