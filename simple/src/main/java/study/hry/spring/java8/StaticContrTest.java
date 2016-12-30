package study.hry.spring.java8;

/**
 * 方法与构造函数引用
 * Java 8 允许你使用 :: 关键字来传递方法或者构造函数引用
 * 
 * @author Administrator
 *
 */
public class StaticContrTest {

	public static void main(String[] args) {
		
		//Java 8 允许你使用 :: 关键字来传递方法或者构造函数引用，
		// 引用一个类静态方法
		Converter<String, Integer> converter = Integer::valueOf;
		Integer converted = converter.convert("123");
		System.out.println(converted);   // 123
		
		// 引用一个对象的方法
		String something = new String();
		Converter<String, Boolean> converterObj = something::startsWith;
		System.out.println(converterObj.convert("Java"));    
		
		// 引用的构造函数是如何使用
		// 这里我们使用构造函数引用来将他们关联起来，而不是实现一个完整的工厂：
		PersonFactory<Person> personFactory = Person::new;
		Person person = personFactory.create("Peter", "Parker");
		System.out.println(person);
		
	}

}

// 定义Person
class Person {
    String firstName;
    String lastName;
    Person() {}
    Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
// 接下来我们指定一个用来创建Person对象的对象工厂接口：
interface PersonFactory<P extends Person> {
    P create(String firstName, String lastName);
}