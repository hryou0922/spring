package cn.com.pubinfo.ecp.cw.interceptor.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import cn.com.pubinfo.ecp.cw.common.MultipleDataSource;

@Component
@Aspect
public class MultipleDataSourceAspectAdvice {
	private static final String DATABASE_ECPCN = "ecpcn";
	private static final String DATABASE_UAB = "uab";
	
    @Around("execution(* cn.com.pubinfo.ecp.cw.mapper.ecpcn.*.*(..))")
    public Object doAroundEcpCn(ProceedingJoinPoint jp) throws Throwable {
    	System.out.println("doAroundEcpCn aop === " + jp.getTarget() + jp.getTarget().getClass() + jp.getThis());
    	MultipleDataSource.setDataSourceKey(DATABASE_ECPCN);
        return jp.proceed();
    }
    
    @Around("execution(* cn.com.pubinfo.ecp.cw.mapper.uab.*.*(..))")
    public Object doAroundUab(ProceedingJoinPoint jp) throws Throwable {
    	System.out.println("doAroundUab === " + jp.getTarget());
    	MultipleDataSource.setDataSourceKey(DATABASE_UAB);
        return jp.proceed();
    }
}