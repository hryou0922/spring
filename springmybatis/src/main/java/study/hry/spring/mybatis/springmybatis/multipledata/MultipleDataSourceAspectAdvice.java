package study.hry.spring.mybatis.springmybatis.multipledata;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MultipleDataSourceAspectAdvice {
	private static final String DATABASE_TEST1 = "test1";
	private static final String DATABASE_TEST2 = "test2";
	
    @Around("execution(* study.hry.spring.mybatis.springmybatis.multipledata.mapper.test1.*.*(..))")
    public Object doAroundTest1(ProceedingJoinPoint jp) throws Throwable {
    	System.out.println("doAroundTest1 aop === " + jp.getTarget() + jp.getTarget().getClass() + jp.getThis());
    	MultipleDataSource.setDataSourceKey(DATABASE_TEST1);
        return jp.proceed();
    }
    
    @Around("execution(* study.hry.spring.mybatis.springmybatis.multipledata.mapper.test2.*.*(..))")
    public Object doAroundTest2(ProceedingJoinPoint jp) throws Throwable {
    	System.out.println("doAroundTest2 === " + jp.getTarget());
    	MultipleDataSource.setDataSourceKey(DATABASE_TEST2);
        return jp.proceed();
    }
}