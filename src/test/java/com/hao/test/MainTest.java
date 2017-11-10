package com.hao.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hao.manager.FrontDesk;

public class MainTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ApplicationContext context = new ClassPathXmlApplicationContext("spring-beans.xml");
		FrontDesk frontDesk = context.getBean("FrontDesk", FrontDesk.class);
	}
	
}
