package study.hry.spring.java8;

public class ObjectFieldStaticField {
	public static void main(String[] args) {
		Lambda4 lam = new Lambda4();
		lam.testScopes();
	}
}

class Lambda4 {
	static int outerStaticNum;
	int outerNum;
	
	// 和本地变量不同的是，lambda内部对于实例的字段以及静态变量是即可读又可写。该行为和匿名对象是一致的
	void testScopes() {
		Converter<Integer, String> stringConverter1 = (from) -> {
			outerNum = 23;
			return String.valueOf(from + outerNum);
		};
		System.out.println(stringConverter1.convert(1));
		Converter<Integer, String> stringConverter2 = (from) -> {
			outerStaticNum = 72;
			return String.valueOf(from + outerStaticNum);
		};
		System.out.println(stringConverter2.convert(3));
	}
}
