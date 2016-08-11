package study.hry.spring.mybatis.springmybatis.generate;

import org.mybatis.generator.api.ShellRunner;

public class MybatisGenerateCompanyUabMain {

	public static void main(String[] args) {
		// 
		// java -jar "C:/UU/repository/mvn/org/mybatis/generator/mybatis-generator-core/1.3.3/mybatis-generator-core-1.3.2.jar" -configfile "C:/UU/work_tool/spring/springmybatis/src/main/resources/simple/generator.xml" -overwrite
		
		String generatorFile = "D:/eclipse_study/spring/springmybatis/src/main/resources/generate/generatorOracleUab.xml";
		String[] tmpArgs = {"-configfile", generatorFile, "-overwrite"};
		ShellRunner.main(tmpArgs);
		
	}

}
