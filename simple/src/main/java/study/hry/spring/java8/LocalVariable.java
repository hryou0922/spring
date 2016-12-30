package study.hry.spring.java8;

/**
 * 在lambda表达式中访问外层的局部变量
 * 
 * @author Administrator
 *
 */
public class LocalVariable {
	public static void main(String[] args) {
		
		// 但是和匿名对象不同的是，这里的变量num可以不用声明为final，该代码同样正确：
		// int num = 1; // 不过这里的num必须不可被后面的代码修改（即隐性的具有final的语义）
		final int num = 1;
		Converter<Integer, String> stringConverter =
		        (from) -> String.valueOf(from + num);
		System.out.println(stringConverter.convert(2));     // 3
		
		// 不过这里的num必须不可被后面的代码修改（即隐性的具有final的语义）
		// num = 3;
	}
}
