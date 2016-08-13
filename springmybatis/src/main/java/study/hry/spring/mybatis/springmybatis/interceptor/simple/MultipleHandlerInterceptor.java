package study.hry.spring.mybatis.springmybatis.interceptor.simple;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Signature;

/**
 * 同一个拦截器拦截多个方法
 * @author kk
 *
 */
@Intercepts(
		{ @Signature(method = "prepare", 
			type = StatementHandler.class, 
			args = { Connection.class, Integer.class }) 
			,
			@Signature(method = "setParameters", 
				type = ParameterHandler.class, 
				args = { PreparedStatement.class }) 
			,
			@Signature(method = "handleResultSets", 
				type = ResultSetHandler.class, 
				args = { Statement.class }) 
		})
public class MultipleHandlerInterceptor extends AbstractInterceptor {

}
