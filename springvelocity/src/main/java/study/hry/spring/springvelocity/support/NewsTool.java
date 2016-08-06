package study.hry.spring.springvelocity.support;

import java.util.ArrayList;
import java.util.List;

public class NewsTool {
    public List<Customer> ListTopNews(int top){
    	List<Customer> list = new ArrayList<Customer>();
    	Customer c = new Customer();
    	c.setValue("value1");
    	c.setName("name1");
    	list.add(c);
    	
    	c = new Customer();
    	c.setValue("value2");
    	c.setName("name2");
    	list.add(c);
    	
    	c = new Customer();
    	c.setValue("value3");
    	c.setName("name3");
    	list.add(c);
    	
        return list;
    }
     
    /** To test exception handling in templates. */
    public boolean whine() {
        throw new IllegalArgumentException();
    }
}
