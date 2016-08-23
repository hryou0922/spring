package study.hry.spring.mybatis.springmybatis.interceptor;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import study.hry.spring.mybatis.springmybatis.simple.mapper.UsersMapper;
import study.hry.spring.mybatis.springmybatis.simple.model.Users;

public class InterceptorTest {
	ApplicationContext applicationContext = new ClassPathXmlApplicationContext("interceptor/spring.xml");
	UsersMapper usersMapper;
	
	@Before
	public void init(){
		usersMapper = applicationContext.getBean(UsersMapper.class);
	}
	
	@Test
	public void query(){
		System.out.println("=============== update =======================");
		Random rd = new Random();
		String userId = rd.nextInt(100) + "";
		Users usr = new Users();
		usr.setUserId(userId);
		usr.setUserName("username");
		System.out.println("add: " + usersMapper.insertSelective(usr));
		System.out.println("=============== update end =======================");

		System.out.println("================ query ======================");
		System.out.println(usersMapper.selectByPrimaryKey(userId));
		System.out.println("================ query end ======================");
	}
	
}
