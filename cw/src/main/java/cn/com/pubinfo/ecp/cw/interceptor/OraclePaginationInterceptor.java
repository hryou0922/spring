package cn.com.pubinfo.ecp.cw.interceptor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import org.apache.ibatis.executor.statement.BaseStatementHandler;
import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.scripting.defaults.DefaultParameterHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.pubinfo.ecp.cw.common.DataList;
import cn.com.pubinfo.ecp.cw.exception.DaoException;
import cn.com.pubinfo.ecp.cw.qry.AbstractQry;
import cn.com.pubinfo.ecp.cw.util.ReflectionUtil;


// @Intercepts({ @Signature(type = StatementHandler.class, method = "prepare", args = { Connection.class, Integer.class }) })
@Intercepts({ @Signature(type = StatementHandler.class, method = "prepare", args = { Connection.class,  Integer.class }) })
public class OraclePaginationInterceptor implements Interceptor {
    private static final Logger log=LoggerFactory.getLogger(OraclePaginationInterceptor.class);
	private String paginationMethodFlag = "WithPage";
	
//	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		Object target = invocation.getTarget();
		if (target instanceof RoutingStatementHandler) {
			RoutingStatementHandler statementHandler = (RoutingStatementHandler) target;
			BaseStatementHandler delegate = (BaseStatementHandler) ReflectionUtil
					.getFieldValue(statementHandler, "delegate");
			MappedStatement mappedStatement = (MappedStatement) ReflectionUtil
					.getFieldValue(delegate, "mappedStatement");
			// 如果SQL的id包含分页标识
			if (mappedStatement.getId().contains(paginationMethodFlag)) {
				BoundSql boundSql = delegate.getBoundSql();
				Object parameterObject = boundSql.getParameterObject();

				// 如果方法有分页标识但又没有分页参数，则抛异常
				if (parameterObject == null
						|| !(parameterObject instanceof AbstractQry)) {
					log.error("分页查询[{0}]没有设置分页条件");
					throw new DaoException(100, boundSql.getSql());				
				}


				String sql = boundSql.getSql();
				AbstractQry paginationQuery = (AbstractQry) parameterObject;
				if(Boolean.TRUE.equals(paginationQuery.getRequireTotalCount())){
					// 生成查询记录总数的countSql					
					String countSql = generateCountSql(sql);
					Connection connection = (Connection) invocation.getArgs()[0];
					PreparedStatement countStmt = connection
							.prepareStatement(countSql);

					// 为countSql的参数赋值
					DefaultParameterHandler dph = new DefaultParameterHandler(
							mappedStatement, parameterObject, boundSql);
					dph.setParameters(countStmt);

					// 执行查询并获取结果
					ResultSet rs = countStmt.executeQuery();
					int count = 0;
					if (rs.next()) {
						count = rs.getInt(1);
					}
					// 总记录数通过分页查询参数赋值
					paginationQuery.setTotalCount(count);
				}
				
				// 给查询结果集的SQL拼接上分页语句
				Integer start=paginationQuery.getOffset();
				if(start==null){
					start=0;
					paginationQuery.setOffset(start);
				}
				Integer limit=paginationQuery.getLimit();
				if(limit==null){
					limit=DataList.DEFAULT_PAGE_SIZE;
					paginationQuery.setLimit(limit);
				}
				String pageSql = generatePageSql(sql,start , limit);
				ReflectionUtil.setFieldValue(boundSql, "sql", pageSql);

			}
		}
		return invocation.proceed();// 返回的是java.sql.Statement
	}

//	@Override
	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

//	@Override
	public void setProperties(Properties properties) {
		if (properties.getProperty("paginationMethodFlag") != null) {
			paginationMethodFlag = properties
					.getProperty("paginationMethodFlag");
		}

	}

	
	public String generatePageSql(String querySql, int start, int limit) {		
		StringBuffer pageSql = new StringBuffer();
		pageSql.append("select * from (select tmp_tb.*,ROWNUM row_id from (");
			pageSql.append(querySql);
			pageSql.append(")  tmp_tb where ROWNUM<=");
			pageSql.append(start + limit);
			pageSql.append(") where row_id>");
			pageSql.append(start);
		
		return pageSql.toString();
		
	}

	/**
	 * 生成对应的统计条件的SQL
	 * @param sql
	 * @return 
	 */
	private String generateCountSql(String sql){	
		String upperSql = sql.trim().toUpperCase();
		int firstFromIndex=upperSql.indexOf(" FROM ");
		return "select count(1) "+upperSql.substring(firstFromIndex);
//		int startIndex = 0;
//		int stack = 1;//select的栈，遇from则-1,
//		for(int i=0; i<10; i++){
//			int indexs =upperSql.indexOf("SELECT ", startIndex+2);
//			int indexf =upperSql.indexOf("FROM ", startIndex+2);
//			if(indexs<0 || indexf < indexs){
//				stack--;
//				startIndex = indexf;
//			}else{
//				stack++;
//				startIndex = indexs;
//			}
//			if(stack==0){
//				return "select count(1)  " + sql.substring(indexf);//更简捷的计数sql
//			}
//		}
//		//通用的计数sql，但可能给数据库带来额外压力。
//		return "select count(1) from (" + sql + ") myCount";
	}	

  
}