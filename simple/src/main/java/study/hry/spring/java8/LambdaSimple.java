package study.hry.spring.java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaSimple {

	public static void main(String[] args) {
		
		// 首先看看在老版本的Java中是如何排列字符串的：
		List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
		Collections.sort(names, new Comparator<String>() {
		    @Override
		    public int compare(String a, String b) {
		        return b.compareTo(a);
		    }
		});
		
		// lambda表达式
		Collections.sort(names, (String a, String b) -> {
		    return b.compareTo(a);
		});
		
		// lambda更简化
		Collections.sort(names, (String a, String b) -> b.compareTo(a));
		
		// 对于函数体只有一行代码的，你可以去掉大括号{}以及return关键字，但是你还可以写得更短点
		Collections.sort(names, (a, b) -> b.compareTo(a));
	}

}
