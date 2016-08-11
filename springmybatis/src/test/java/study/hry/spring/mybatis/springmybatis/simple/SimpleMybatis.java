package study.hry.spring.mybatis.springmybatis.simple;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import study.hry.spring.mybatis.springmybatis.simple.mapper.UsersMapper;

public class SimpleMybatis {
	
	public static void main(String[] args) {
		//初始化ApplicationContext
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("simple/spring.xml");
        
        UsersMapper userMapper = applicationContext.getBean(UsersMapper.class);
        System.out.println(userMapper.selectByPrimaryKey("1"));
        
        
	}
}
