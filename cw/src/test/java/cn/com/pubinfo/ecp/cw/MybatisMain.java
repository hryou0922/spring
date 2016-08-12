package cn.com.pubinfo.ecp.cw;

import java.math.BigDecimal;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.com.pubinfo.ecp.cw.mapper.ecpcn.CustomerUserMapper;
import cn.com.pubinfo.ecp.cw.mapper.uab.EabContactMapper;

public class MybatisMain {
	
	public static void main(String[] args) {
		//初始化ApplicationContext
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("config/spring_base.xml");

        CustomerUserMapper customerUserMapper = applicationContext.getBean(CustomerUserMapper.class);

        EabContactMapper sqlServerMapper = applicationContext.getBean(EabContactMapper.class);
        
        //设置数据源为MySql,使用了AOP测试时请将下面这行注释
 //       MultipleDataSource.setDataSourceKey("ecpcn");
        System.out.println(customerUserMapper.selectByPrimaryKey(new BigDecimal(102082467)));
     //   mySqlMapper.insertSelective(record);
        //设置数据源为SqlServer,使用AOP测试时请将下面这行注释
    //    MultipleDataSource.setDataSourceKey("uab");
        System.out.println(sqlServerMapper.selectByPrimaryKey("8f3f2c55-b5c9-4bba-89da-f4fc97912a3b"));
        
	}
}
