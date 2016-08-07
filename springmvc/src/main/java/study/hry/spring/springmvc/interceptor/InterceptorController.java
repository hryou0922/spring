package study.hry.spring.springmvc.interceptor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InterceptorController {
	
	/**
	 * http://localhost:8080/springmvc/mvc/interceptor
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/interceptor")
    public String first(Model model) {
		System.out.println("controler = " + this.getClass().getName());
        return "interceptor/interceptor";
    }
}
