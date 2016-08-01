package study.hry.spring.springmvc.formtag;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FormTagController {
	
	@RequestMapping(value = "/user/info", method = RequestMethod.GET)
	public String saveEmployeeAction(Model model) {
		User user = new User();
		user.setFirstName("firstName");
		user.setLastName("lastName");
		user.setSex("M");
		
		Preferences p = new Preferences();
		p.setReceiveNewsletter(true);
		p.setFavouriteWord("Magic");
		String[] interests = {"Quidditch",""};
		p.setInterests(interests);
		user.setPreferences(p);
		
		// 默认form tag的值未command
		// model.addAttribute("command", user);
		model.addAttribute("user",user);
		
		// interest2;
		String[] interests2 = {"interests1","interests2"};  
	    model.addAttribute("interestList", interests2); 
		
	    // sexOptions
	    Map<String,String> sexOptions = new HashMap<String,String>();
	    sexOptions.put("M", "男"); 
	    sexOptions.put("F", "女"); 
	    model.addAttribute("sexOptions", sexOptions);
	    
		return "formtag/form";
	}
}
