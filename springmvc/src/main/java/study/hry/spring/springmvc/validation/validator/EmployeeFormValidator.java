package study.hry.spring.springmvc.validation.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class EmployeeFormValidator implements Validator {

	//which objects can be validated by this validator
	@Override
	public boolean supports(Class<?> paramClass) {
		return Employee.class.equals(paramClass);
	}

	/**
	 * /// Once this method returns, spring framework binds the Errors object to the BindingResult 
	 * 	object that we use in our controller handler method.
	 */
	@Override
	public void validate(Object obj, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "id.required");
		
		Employee emp = (Employee) obj;
		if(emp.getId() <=0){
			// 第二个参数和message里“negativeValue”的key值
			errors.rejectValue("id", "negativeValue", new Object[]{"'id'"}, "id can't be negative");
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name.required");
		// 第二个参数是熟悉名称，第三个参数是消息的key
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "role", "role.required");
	}
}
