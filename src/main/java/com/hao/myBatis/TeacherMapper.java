package com.hao.myBatis;

import java.util.List;

import com.hao.personnel.information.Teacher;

public interface TeacherMapper {

	/**
	 * create table
	 */
	public void create();

	public void add(Teacher teacher);

	public void delById(Integer id);

	public List<Teacher> list();
}
