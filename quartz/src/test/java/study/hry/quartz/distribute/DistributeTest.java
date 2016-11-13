package study.hry.quartz.distribute;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DistributeTest {
	
	@Test
	public void init() throws InterruptedException{
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:quartz/distributed/spring-quartz.xml");
	
		Thread.sleep(1000 * 20);
	}
	
}
