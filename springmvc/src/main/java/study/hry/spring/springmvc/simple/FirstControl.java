package study.hry.spring.springmvc.simple;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FirstControl {
	
	/**
	 * http://localhost:8080/springmvc/mvc/first
	 * 	返回页面page/first/index.jsp
	 * @param model
	 * @return
	 */
	@RequestMapping("/first")
    public String first(Model model) {
        model.addAttribute("message", "Hello World!");
        return "first/index";
    }	
}
