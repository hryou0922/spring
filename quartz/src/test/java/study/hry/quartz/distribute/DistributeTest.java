package study.hry.quartz.distribute;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DistributeTest {
	
	@Test
	public void init() throws InterruptedException{
		int num = 10;
		
		while(num-- > 0){
			ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:quartz/distributed/spring-quartz.xml");
			Thread.sleep(1000 * 3);
		}
		Thread.sleep(1000 * 60);
	}
	
}
