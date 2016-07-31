package study.hry.spring.springmvc.formtag;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import study.hry.spring.springmvc.validation.validator.Employee;

@Controller
public class FormTagController {
	
	@RequestMapping(value = "/user/info", method = RequestMethod.GET)
	public String saveEmployeeAction(Model model) {
		User user = new User();
		user.setFirstName("firstName");
		user.setLastName("lastName");
		
		Preferences p = new Preferences();
		p.setReceiveNewsletter(true);
		p.setFavouriteWord("Magic");
		String[] interests = {"Quidditch",""};
		p.setInterests(interests);
		user.setPreferences(p);
		
		// 默认form tag的值未command
		// model.addAttribute("command", user);
		model.addAttribute("user",user);
		
		return "formtag/form";
	}
}
