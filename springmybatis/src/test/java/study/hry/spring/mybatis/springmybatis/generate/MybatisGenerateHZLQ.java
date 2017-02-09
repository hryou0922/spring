package study.hry.spring.mybatis.springmybatis.generate;

import org.mybatis.generator.api.ShellRunner;

public class MybatisGenerateHZLQ {

	public static void main(String[] args) {
		// 
		// java -jar "C:/UU/repository/mvn/org/mybatis/generator/mybatis-generator-core/1.3.3/mybatis-generator-core-1.3.2.jar" -configfile "C:/UU/work_tool/spring/springmybatis/src/main/resources/simple/generator.xml" -overwrite
		System.out.println("---being --- ");
		String generatorFile = "D:/eclipse_study/spring/springmybatis/src/main/resources/generate/generatorOracleHZLQ.xml";
//		String[] tmpArgs = {"-configfile", generatorFile, "-overwrite"};
		String[] tmpArgs = {"-configfile", generatorFile};
		ShellRunner.main(tmpArgs);
		System.out.println("--  end --- ");
		
	}

}
