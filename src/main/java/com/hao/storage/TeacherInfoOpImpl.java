package com.hao.storage;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import com.hao.myBatis.MapperFactory;
import com.hao.myBatis.TeacherMapper;
import com.hao.personnel.information.Teacher;

public class TeacherInfoOpImpl implements TeacherInfoOp {

	public void add(Teacher teacher) {
		// TODO Auto-generated method stub
		SqlSession session = null;
		try {
			session = MapperFactory.getSqlSession();
		
			TeacherMapper teacherMapper = session.getMapper(TeacherMapper.class);
			teacherMapper.add(teacher);
			session.commit();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			if(session!=null)
				session.close();
		}

	}

	public void list() {
		// TODO Auto-generated method stub
		SqlSession session = null;
		try {
			session = MapperFactory.getSqlSession();
			TeacherMapper teacherMapper = session.getMapper(TeacherMapper.class);
			List<Teacher> list = teacherMapper.list();
			for (Teacher teacher : list) {
				System.out.println(teacher);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			if(session!=null)
				session.close();
		}
	}

}
