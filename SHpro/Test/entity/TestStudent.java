package entity;

import java.util.Date;
import java.util.EnumSet;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import org.junit.Test;

public class TestStudent {

	@Test
	public void testSchemaExport(){
		//创建配置对象
		Configuration config=new Configuration().configure();
		//创建服务注册对象
		ServiceRegistry serviceRegistry=new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
		//创建sessionFactory
		SessionFactory sessionFactory=config.buildSessionFactory(serviceRegistry);
		//创建session对象
		Session session=sessionFactory.getCurrentSession();
		//创建SchemaExport对象
		SchemaExport export=new SchemaExport(config);
		export.create(true,true);
	}
	@Test
	public void testSaveStudents(){
		//创建配置对象
		Configuration config=new Configuration().configure();
		//创建服务注册对象
		ServiceRegistry serviceRegistry=new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
		//创建sessionFactory
		SessionFactory sessionFactory=config.buildSessionFactory(serviceRegistry);
		//创建session对象
		Session session=sessionFactory.getCurrentSession();
		//创建事务对象
		Transaction tx=session.beginTransaction();
		Students s1=new Students("001","无忌","男",new Date(),"武当");
		Students s2=new Students("002","夜华","男",new Date(),"天族");
		Students s3=new Students("003","白浅","女",new Date(),"青丘");
		session.save(s1);
		session.save(s2);
		session.save(s3);
		tx.commit();
		sessionFactory.close();
	}
}
