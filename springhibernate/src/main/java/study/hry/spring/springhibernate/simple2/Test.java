package study.hry.spring.springhibernate.simple2;

import java.util.Random;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Test {
	
	public static void main(String[] args) {
		Session session = SessionFactoryUtil.getInstance().getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		Random rd = new Random();
		House house = new House();//瞬态
		house.setId(rd.nextInt(100));
		house.setName("forest honey");
		house.setAddress("beijing");
		
		session.save(house);//持久态
		
		//对持久态对象进行修改
		house.setAddress("yj1212");
		
		Person person = new Person();//瞬态
		person.setId(1);
		person.setAge(24);
		person.setName("张三");
		session.save(person);//持久态
		
		session.delete(person);//session关闭后此person便会成为托管态对象
		
		tx.commit();//提交事务，提交后会自动关闭session
		
		session.close();
	}
}
