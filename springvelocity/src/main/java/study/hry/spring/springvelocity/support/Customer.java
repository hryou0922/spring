package study.hry.spring.springvelocity.support;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Customer {
	private String name;
	private String value;
	private List<String> list;
	private boolean condition;
	private Map<String, String> map = new HashMap<String,String>();
	
	public Customer(){
		this.name = "name";
		this.value = "value";
		list = new ArrayList<String>();
		list.add("list_1");
		list.add("list_2");
		list.add("list_3");
		condition = true;
		
		map.put("key1", "value1");
		map.put("key2", "value2");
		map.put("key3", "value3");
		map.put("key4", "value4");
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	public boolean isCondition() {
		return condition;
	}

	public void setCondition(boolean condition) {
		this.condition = condition;
	}

	public Map<String, String> getMap() {
		return map;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}
	
	
}
