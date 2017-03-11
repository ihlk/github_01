package service.impl;

import java.util.Date;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import entity.Students;

import service.StudentsDAO;

public class TestStudentsDAOImpl {
/*
	@Test
	public void testQueryAllStudents(){
		StudentsDAO sdao=new StudentsDAOImpl();
		List<Students> list=sdao.queryAllStudents();
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
		}
	}
*/
	/*@Test
	public void testGetNewSid(){
		StudentsDAOImpl sdao=new StudentsDAOImpl();
		System.out.println(sdao.getNewSid());
	}
	*/
/*	@Test
	public void testAddStudents(){
		StudentsDAOImpl sdao=new StudentsDAOImpl();
		Students s=new Students();
		s.setSname("夜华");
		s.setGender("男");
		s.setBirthday(new Date());
		s.setAddress("九重天");
		Assert.assertEquals(true, sdao.addStudents(s));
		
	}
	*/
	@Test
	public void testUpdateStudents(){
		StudentsDAOImpl sdao=new StudentsDAOImpl();
		Students s=new Students();
		s.setSid("002");
		s.setSname("少幸");
		s.setGender("女");
		s.setBirthday(new Date());
		s.setAddress("西海");
		Assert.assertEquals(true, sdao.updateStudents(s));
		
	}
}
