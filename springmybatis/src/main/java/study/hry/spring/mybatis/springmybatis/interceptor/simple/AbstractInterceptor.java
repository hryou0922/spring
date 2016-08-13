package study.hry.spring.mybatis.springmybatis.interceptor.simple;

import java.util.Properties;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;

public class AbstractInterceptor implements Interceptor {

	public Object intercept(Invocation invocation) throws Throwable {
		System.out.println(this.getClass().getCanonicalName() + " intercept " + invocation.getTarget());
		Object result = invocation.proceed();
		return result;
	}

	public Object plugin(Object target) {
		System.out.println(this.getClass().getCanonicalName() + " wrap plugin" );
		return Plugin.wrap(target, this);
	}

	public void setProperties(Properties properties) {
		System.out.println(this.getClass().getCanonicalName() + ":setProperties");
	}

}
