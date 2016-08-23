package study.hry.spring.mybatis.springmybatis.interceptor.page;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import study.hry.spring.mybatis.springmybatis.simple.mapper.UsersMapper;
import study.hry.spring.mybatis.springmybatis.simple.model.Users;

public class PageTest {
	ApplicationContext applicationContext = new ClassPathXmlApplicationContext("interceptor/page/spring.xml");
	UsersMapper usersMapper;
	
	@Before
	public void init(){
		usersMapper = applicationContext.getBean(UsersMapper.class);
	}
	
	@Test
	public void query(){
		Page<Users> page = new Page<Users>();
		page.setPageNo(2);
		List<Users> list = usersMapper.queryList(page);
		System.out.println("size = " + list.size());
		System.out.println("Page = " + page);
	}
	
}
