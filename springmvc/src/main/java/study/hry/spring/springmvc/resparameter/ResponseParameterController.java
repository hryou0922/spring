package study.hry.spring.springmvc.resparameter;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * 各种结果返回
 * 
 */
@Controller
@RequestMapping(value = "/response")
public class ResponseParameterController {

	// =================== @ResponseBody================================
	/**
	 * 直接返回字符串内容
	 * 	http://localhost:8080/springmvc/mvc/response/responseBody
	 * @return
	 */
	@RequestMapping(value = "/responseBody", method = RequestMethod.GET)
	@ResponseBody
	public String responseBodyString() {
	    return "Hello World";
	}
	
	/**
	 * 返回对象，格式json
	 * http://localhost:8080/springmvc/mvc/response/responseBodyMode
	 * @return
	 */
	@RequestMapping(value = "/responseBodyMode", method = RequestMethod.GET)
	@ResponseBody
	public VO responseBodyMode() {
	    return new VO();
	}
	
	// =================== @ResponseBody end ================================
	
	// =============== HttpEntity ================
	/**
	 * http://localhost:8080/springmvc/mvc/response/responseEntity
	 * @return
	 */
	@RequestMapping("/responseEntity")
	public ResponseEntity<String> responseEntity(){
	    // do something with request header and body
	    HttpHeaders responseHeaders = new HttpHeaders();
	    responseHeaders.set("MyResponseHeader", "MyValue");
	    return new ResponseEntity<String>("Hello World", responseHeaders, HttpStatus.CREATED);
	}
	// ===================HttpEntity end=============================
	
	// =============== ModelAndView ================
	/**
	 * http://localhost:8080/springmvc/mvc/response/modelAndView
	 * @return
	 */
	@RequestMapping("/modelAndView")
	public ModelAndView modelAndView(){
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("ownerId", "1");
		map.put("petId", "23");
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("resparameter/showInput");
		modelAndView.addObject("map", map);
		
		return modelAndView;
	}
	// ===================ModelAndView end=============================
	
	
//	// =============== View ================
//	/**
//	 * http://localhost:8080/springmvc/mvc/response/modelAndView
//	 * @return
//	 */
//	@RequestMapping("/view")
//	public View view(){
//		
//		Map<String,Object> map = new HashMap<String,Object>();
//		map.put("ownerId", "1");
//		map.put("petId", "23");
//		
//		View view = new View
//		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.setViewName("resparameter/showInput");
//		modelAndView.addObject("map", map);
//		
//		return modelAndView;
//	}
//	// ===================View end=============================
//	
 
}
