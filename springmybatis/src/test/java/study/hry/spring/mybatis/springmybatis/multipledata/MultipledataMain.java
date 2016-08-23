package study.hry.spring.mybatis.springmybatis.multipledata;

import java.util.Random;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import study.hry.spring.mybatis.springmybatis.multipledata.mapper.test1.UsersTest1Mapper;
import study.hry.spring.mybatis.springmybatis.multipledata.mapper.test2.UsersTest2Mapper;
import study.hry.spring.mybatis.springmybatis.multipledata.model.test1.UsersTest1;
import study.hry.spring.mybatis.springmybatis.multipledata.model.test2.UsersTest2;

public class MultipledataMain {
	//初始化ApplicationContext
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("multipledata/spring.xml");
 
    @Test
    public void multiple(){
    	UsersTest1Mapper userTest1Mapper = applicationContext.getBean(UsersTest1Mapper.class);
    	UsersTest2Mapper userTest2Mapper = applicationContext.getBean(UsersTest2Mapper.class);
    	
    	Random rd = new Random();
    	UsersTest1 test1 = new UsersTest1();
    	String id = rd.nextInt(10000) + "";
    	test1.setUserId(id);
    	test1.setUserName("userName");
    	System.out.println("insert result = " + userTest1Mapper.insertSelective(test1));
    	System.out.println(userTest1Mapper.selectByPrimaryKey(id));
    	
    	UsersTest2 test2 = new UsersTest2();
    	id = rd.nextInt(10000) + "";
    	test2.setUserId(id);
    	test2.setUserName("userName");
    	System.out.println("insert result = " + userTest2Mapper.insertSelective(test2));
    	System.out.println(userTest2Mapper.selectByPrimaryKey(id));
    	
    	
    }
 
}
