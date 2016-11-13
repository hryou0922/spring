package study.hry.quartz.distribute;

import java.util.Date;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class StatisticsJob extends QuartzJobBean{

	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		
		System.out.println("测试定时任务----------------------------------------------------------------------------------");
		Date start = new Date();
		System.out.println("start:"+start);
//		try {
//			Thread.sleep(20000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		long end = new Date().getTime();
		System.out.println("定时任务执行结束时间："+start);
	}

}
