package study.hry.spring.springhibernate.simple;

import java.io.File;
import java.util.Random;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HbMain {

	public static void main(String[] args) {
		Configuration conf = new Configuration();
		
		// 下面的方法默认加载hibernate.cfg.xml文件
//		conf.configure(file);
		
		String file = HbMain.class.getClassLoader().getResource(".").getPath()
				+ "study/hry/spring/springhibernate/simple/hibernate.cfg.xml";		
		System.out.println(file);
		conf.configure(new File(file));

		// 创建sessionFactory
		SessionFactory sf = conf.buildSessionFactory();
		// 创建session
		Session sess = sf.openSession();
		// 开始事务,Hibernate必须显式的手动提交事务
		Transaction tx = sess.beginTransaction();

		TmpEmp tmpEmp = new TmpEmp();
		Random rd = new Random();
		tmpEmp.setId(rd.nextInt(1000));
		tmpEmp.setName("yz");

		// 保存
		sess.save(tmpEmp);

		// 提交事务
		tx.commit();

		// 关闭session
		sess.flush();
		sess.close();
		sf.close();

	}

}
