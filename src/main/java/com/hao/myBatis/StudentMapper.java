package com.hao.myBatis;

import java.util.List;

import com.hao.personnel.information.Student;

public interface StudentMapper {

	public void create();

	public void add(Student student);

	public void delById(Integer id);

	public List<Student> list();
}
