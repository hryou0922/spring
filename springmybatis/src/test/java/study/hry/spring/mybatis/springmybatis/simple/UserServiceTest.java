package study.hry.spring.mybatis.springmybatis.simple;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import study.hry.spring.mybatis.springmybatis.simple.model.Users;
import study.hry.spring.mybatis.springmybatis.simple.service.IUserService;

public class UserServiceTest {
	ApplicationContext applicationContext = new ClassPathXmlApplicationContext("simple/spring.xml");
	IUserService userService;
	@Before
	public void init(){
		userService = applicationContext.getBean(IUserService.class);
	}
	
	@Test
	public void save(){
		Random rd = new Random();
		Users usr = new Users();
		usr.setUserId(rd.nextInt(100) + "");
		usr.setUserName("username");
		userService.save(usr);
	}
	
	@Test
	public void saveThrowException(){
		Random rd = new Random();
		Users usr = new Users();
		usr.setUserId(rd.nextInt(1000) + "");
		usr.setUserName("username");
		userService.saveThrowException(usr);
	}
}
