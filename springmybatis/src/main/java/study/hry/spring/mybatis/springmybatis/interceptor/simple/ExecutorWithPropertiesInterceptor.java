package study.hry.spring.mybatis.springmybatis.interceptor.simple;

import java.util.Properties;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

@Intercepts(
		{ @Signature(method = "query", 
			type = Executor.class, 
			args = { MappedStatement.class, Object.class,RowBounds.class, ResultHandler.class }) 
		})
public class ExecutorWithPropertiesInterceptor extends AbstractInterceptor {


	/**
	 * 从配置里获取熟悉值
	 */
	public void setProperties(Properties properties) {
		super.setProperties(properties);
		String prop1 = properties.getProperty("prop1");
		String prop2 = properties.getProperty("prop2");
		System.out.println(prop1 + "------" + prop2);
	}

}
