package study.hry.spring.springmvc.simple;

import java.io.IOException;
import java.io.Writer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="owners") // 全局URL
public class URITemplate {
	
	/**
	 * http://localhost:8080/springmvc/mvc/owners/123/pets/45
	 * 
	 * @param ownerId
	 * @param petId
	 * @return
	 */
	@RequestMapping(value="/{ownerId}/pets/{petId}", method=RequestMethod.GET)
	public String pathVariable(@PathVariable String ownerId, @PathVariable String petId) {
		System.out.println("ownerId = " + ownerId);
		System.out.println("petId = " + petId);
	    return "/uritemplate/common";
	}
	
	/**
	 * http://localhost:8080/springmvc/mvc/owners/form/form
	 * 
	 * @param page
	 * @return
	 */
	@RequestMapping("/form/{page}")    
	public String form(@PathVariable String page){
		return "uritemplate/"+page;
	}
	
	/**
	 * http://localhost:8080/springmvc/mvc/owners/requestParam
	 * 
	 * @param inputStr
	 * @return
	 */
	@RequestMapping("/requestParam")    
	public String requestParam(@RequestParam(value="inputStr", required=true, defaultValue="noInput") String inputStr) {    
		System.out.println(inputStr); 
	    return "uritemplate/common";  
	}
	
	/**
	 * @RequestBody: 获取请求的内容
	 * 
	 * @param body
	 * @param writer
	 * @throws IOException
	 */
	@RequestMapping(value = "/requestBody", method = RequestMethod.POST)
	public void requestBody(@RequestBody String body, Writer writer) throws IOException {
		// 将返回输入到返回端
	    writer.write(body);
	}
	
	/**
	 * http://localhost:8080/springmvc/mvc/owners/responseBody
	 * 
	 * @ResponseBody:直接将输入内容返回给调用者
	 */
	@RequestMapping(value = "/responseBody", method = RequestMethod.GET)
	@ResponseBody
	public String responseBody(){
		// 将返回输入到返回端
		return "@ResponseBody:------";
	}

}
