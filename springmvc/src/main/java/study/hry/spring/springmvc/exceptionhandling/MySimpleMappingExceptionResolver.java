package study.hry.spring.springmvc.exceptionhandling;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

public class MySimpleMappingExceptionResolver extends SimpleMappingExceptionResolver {
	private static final Logger logger = LoggerFactory.getLogger(MySimpleMappingExceptionResolver.class);

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		logger.info("url = {}, exception message = {}", request.getRequestURI(), ex.getMessage());
		return super.resolveException(request, response, handler, ex);
	}

}
