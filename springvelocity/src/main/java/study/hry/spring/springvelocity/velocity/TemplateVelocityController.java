package study.hry.spring.springvelocity.velocity;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import study.hry.spring.springvelocity.support.Customer;

@Controller
public class TemplateVelocityController {
	
	public TemplateVelocityController(){
		System.out.println("TemplateVelocityController init");
	}
	
	@RequestMapping(value = "/template", method = RequestMethod.GET)
	public String saveCustomerPage(Model model) {
		model.addAttribute("customer", new Customer());
		return "template";
	}
} 
