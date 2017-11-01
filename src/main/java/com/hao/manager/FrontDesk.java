package com.hao.manager;

import java.util.Date;
import java.util.Scanner;

import com.hao.personnel.information.Student;
import com.hao.personnel.information.Teacher;
import com.hao.storage.StudentInfoOp;
import com.hao.storage.TeacherInfoOp;

enum STATUS {
	WAIT_CMD,

	WAIT_TEACHER_NAME, WAIT_TEACHER_BIRTH, WAIT_TEACHER_GENDER, WAIT_TEACHER_FINISH,

	WAIT_STUDENT_NAME, WAIT_STUDENT_BIRTH, WAIT_STUDENT_GENDER, WAIT_STUDENT_TEACHER, WAIT_STUDENT_FINISH
}

class Input {
	public String cmd;
	public Teacher teacher;
	public Student student;
}

public class FrontDesk implements Runnable {

	private StudentInfoOp studentInfoOp;
	private TeacherInfoOp teacherInfoOp;

	public StudentInfoOp getStudentInfoOp() {
		return studentInfoOp;
	}

	public void setStudentInfoOp(StudentInfoOp studentInfoOp) {
		this.studentInfoOp = studentInfoOp;
	}

	public TeacherInfoOp getTeacherInfoOp() {
		return teacherInfoOp;
	}

	public void setTeacherInfoOp(TeacherInfoOp teacherInfoOp) {
		this.teacherInfoOp = teacherInfoOp;
	}

	public void init() {
		new Thread(this).start();
	}

	public void run() {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);

		Input input = new Input();

		int studentCount = 0;
		int teacherCount = 0;

		while (scanner.hasNext()) {

			input.cmd = scanner.next();
			
			if (input.cmd.compareToIgnoreCase("teacher") == 0) {
				input.teacher = new Teacher();
				teacherCount++;
				input.teacher.setName("teacher" + teacherCount);
				input.teacher.setBirth(new Date());
				input.teacher.setGender(teacherCount%2==0);
				teacherInfoOp.add(input.teacher);
				System.out.println(input.teacher);
			} else if (input.cmd.compareToIgnoreCase("student") == 0) {
				input.student = new Student();
				studentCount++;
				input.student.setName("student" + studentCount);
				input.student.setBirth(new Date());
				input.student.setGender(studentCount%2==0);
				input.student.setTeacher("teacher" + teacherCount);
				studentInfoOp.add(input.student);
				System.out.println(input.student);
			}
			else {
				teacherInfoOp.list();
				studentInfoOp.list();
			}
		}
	}
}
