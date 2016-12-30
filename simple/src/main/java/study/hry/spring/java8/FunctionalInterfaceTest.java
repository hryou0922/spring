package study.hry.spring.java8;

/**
 * @FunctionalInterface
 * 函数式接口
 * 
 * @author Administrator
 *
 */
public class FunctionalInterfaceTest {
	
	public static void main(String[] args) {
		Converter<String, Integer> converter = (from) -> Integer.valueOf(from);
		Integer converted = converter.convert("123");
		System.out.println(converted);    // 123
	}
	
}

@FunctionalInterface
interface Converter<F, T> {
    T convert(F from);
}
