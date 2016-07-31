package study.hry.spring.springmvc.validation.validator;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EmployeeController {

	private static final Logger logger = LoggerFactory
			.getLogger(EmployeeController.class);

	private Map<Integer, Employee> emps = null;

	/**
	 * For using custom validator, first we need to inject it 
	 * in the controller class. We are using spring bean auto 
	 * wiring to achieve this using @Autowired and @Qualifier annotations.
	 * 
	 */
	@Autowired
	@Qualifier("employeeValidator")
	private Validator validator;

	/**
	 * Next we need to have a method that will take WebDataBinder 
	 * as argument and we set our custom validator to be used. 
	 * This method should be annotated with @InitBinder annotation.
	 * 
	 * @param binder
	 */
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}

	public EmployeeController() {
		emps = new HashMap<Integer, Employee>();
	}

	@ModelAttribute("employee")
	public Employee createEmployeeModel() {
		// ModelAttribute value should be same as used in the empSave.jsp
		return new Employee();
	}
	/**
	 * http://localhost:8080/springmvc/mvc//emp/save
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/emp/save", method = RequestMethod.GET)
	public String saveEmployeePage(Model model) {
		logger.info("Returning empSave.jsp page");
		return "validation/empSave";
	}

	/**
	 * Using @ModelAttribute is another way to add our 
	 * bean object to the Model
	 * 
	 * @param employee
	 * @param bindingResult
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/emp/save.do", method = RequestMethod.POST)
	public String saveEmployeeAction(
			@ModelAttribute("employee") @Validated Employee employee,
			BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			logger.info("Returning empSave.jsp page");
			return "validation/empSave";
		}
		logger.info("Returning empSaveSuccess.jsp page");
		model.addAttribute("emp", employee);
		emps.put(employee.getId(), employee);
		return "validation/empSaveSuccess";
	}
}