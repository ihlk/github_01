package service.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import db.MyHibernateSessionFactory;

import entity.Students;
import service.StudentsDAO;

public class StudentsDAOImpl implements StudentsDAO{

	//查询所有学生资料
	public List<Students> queryAllStudents() {
		
		Transaction tx=null;
		List<Students> list=null;
		String hql="";
		try{
			Session session=MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			session.beginTransaction();//开启事务
			hql="from Students";
			Query query=session.createQuery(hql);
			list=query.list();
			session.close();//记得关闭事务
			return list;
		}catch(Exception ex)
		{
			ex.printStackTrace();
			tx.rollback();
			return list;
			
		}finally{
			if(tx!=null){
				tx=null;
			}
		}
	}

	//根据学号查询学生资料
	public Students queryStudentsById(String sid) {
		
		Transaction tx=null;
		Students s=null;
		try{
			Session session=MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx=session.beginTransaction();//开启事务
			s=(Students)session.get(Students.class, sid);
			tx.commit();
			
			return s;
		}catch(Exception ex)
		{
			ex.printStackTrace();
			tx.rollback();
			return s;
			
		}finally{
			if(tx!=null){
				tx=null;
			}
			
		}
	}

	//增加学生资料
	public boolean addStudents(Students s) {
		
		s.setSid(getNewSid());
		Transaction tx=null;
		try{
			Session session=MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx=session.beginTransaction();
			session.save(s);
			tx.commit();//事务提交
			return true;
		}catch(Exception ex){
			ex.printStackTrace();
			tx.rollback();//事务回滚
			return false;
		}finally{
			
			if(tx!=null){
				tx=null;
			}
		}
	}

	//更新学生资料
	public boolean updateStudents(Students s) {
		
		Transaction tx=null;
		
		try{
			Session session=MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx=session.beginTransaction();
			session.update(s);
			tx.commit();//事务提交
			
			return true;
		}catch(Exception ex){
			ex.printStackTrace();
			tx.rollback();//事务回滚
			return false;
		}finally{
			
			if(tx!=null){
				tx=null;
			}
		}
	}

	//删除学生资料
	public boolean deleteStudents(String id) {
		Transaction tx=null;
		//String hql="";
		try{
			Session session=MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx=session.beginTransaction();
			Students s=(Students)session.get(Students.class, id);
			session.delete(s);
			tx.commit();
			return true;
			
		}catch(Exception ex){
			ex.printStackTrace();
			tx.rollback();
			return false;
		}finally{
			if(tx!=null){
				tx=null;
			}
		}
		
	}
	//生成学生的学号
	public String getNewSid(){
		Transaction tx=null;
		String hql="";
		String sid=null;
		try{
			Session session=MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx=session.beginTransaction();
			//获得当前学生的最大编号
			hql="select max(sid) from Students";
			Query query=session.createQuery(hql);
			sid=(String)query.uniqueResult();
			if(sid==null||"".equals(sid)){
				//给一个默认的最大编号
				sid="001";
			}else{
				//String temp=sid.substring(1);//取后七位
				String temp="";
				int i=Integer.parseInt(sid);//转为数字
				i++;
				//再还原为字符串
				temp=String.valueOf(i);
				int len=temp.length();
				//凑够三位
				for(int j=0;j<3-len;j++){
					temp="0"+temp;
				}
				//sid="s"+temp;
				sid=temp;
			}
	
			tx.commit();
			return sid;
		}catch(Exception ex){
			ex.printStackTrace();
			tx.rollback();
			return null;
		}finally{
			if(tx!=null){
				tx=null;
			}
			
		}
	}

	
}
