package study.hry.spring.springhibernate.simple2;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity  
@Table(name="PERSON")//表名称和类名称相同时可以不添加此注解来说明  
public class Person {  
    @Id  
    private Integer id;  
    private String name;  
    @AttributeOverride(column = @Column, name = "AGE")//字段名称和属性名称相同可以不添加此注解来说明  
    private int age;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}  
    
    
}