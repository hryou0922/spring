package study.hry.spring.springmvc.exceptionhandling;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import study.hry.spring.springmvc.exceptionhandling.support.EmployeeEx;

@Controller
public class EmployeeExController {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeExController.class);

	/**
	 * http://localhost:8080/springmvc/mvc/emp/1
	 * 
	 * http://localhost:8080/springmvc/mvc/emp/2
	 * 
	 * http://localhost:8080/springmvc/mvc/emp/3
	 * 
	 * http://localhost:8080/springmvc/mvc/emp/4
	 * 
	 * http://localhost:8080/springmvc/mvc/emp/10
	 * 
	 * http://localhost:8080/springmvc/mvc/emp/20
	 * 
	 * @param id
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/emp/{id}", method = RequestMethod.GET)
	public String getEmployee(@PathVariable("id") int id, Model model) throws Exception {
		// deliberately throwing different types of exception
		if (id == 1) {
			throw new EmployeeExNotFoundException(id);
		} else if (id == 2) {
			throw new SQLException("SQLException, id=" + id);
		} else if (id == 3) {
			throw new IOException("IOException, id=" + id);
		} else if (id == 4) {
			throw new EmployeeExJsonException(id);
		} else if (id == 10) {
			EmployeeEx emp = new EmployeeEx();
			emp.setName("Pankaj");
			emp.setId(id);
			model.addAttribute("employee", emp);
			return "home";
		} else {
			throw new Exception("Generic Exception, id=" + id);
		}

	}

	/**
	 * 此方法只处理本类抛出的 EmployeeNotFoundException 异常
	 * 
	 * @param request
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(EmployeeExNotFoundException.class)
	public ModelAndView handleEmployeeNotFoundException(HttpServletRequest request, Exception ex) {
		logger.error("Requested URL=" + request.getRequestURL());
		logger.error("Exception Raised=" + ex);

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("exception", ex);
		modelAndView.addObject("url", request.getRequestURL());

		modelAndView.setViewName("exceptionhandling/error");
		return modelAndView;
	}
}
