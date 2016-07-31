package study.hry.spring.springmvc.simple;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping(value="/rest",produces={"application/xml", "application/json"})  
@RequestMapping(value="/rest")  
public class RestControllerTest {
	
	
    @RequestMapping(value="/vo", method=RequestMethod.GET )  
//    @ResponseStatus(HttpStatus.OK)  
    public VO getUser() {  
    	VO vo = new VO();  
    	vo.setName("name");
    	vo.setValue("value");
        return vo;  
    }  
  
    /**
     * http://localhost:8080/springmvc/mvc/rest/string
     * 
     * 直接返回内容
     * @return
     */
    @RequestMapping(value="/string", method=RequestMethod.GET)  
    // @ResponseStatus(HttpStatus.OK)  
    public String getUserHtml() {
        return "{'example':'---'}";  
    } 
}

class VO{
	private String name;
	private String value;
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
	
}
