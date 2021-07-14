package se.atg.service.harrykart.core;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import se.atg.service.harrykart.common.constant.CommonConstants;
import se.atg.service.harrykart.exception.ValidationException;
import se.atg.service.harrykart.util.CommonUtils;

/**
 * This class is used to catch the exception
 * @author Sumit.Chaturvedi
 * @since 2021-13-07 20:23
 */
@ControllerAdvice
public class RestControllerAdvice extends ResponseEntityExceptionHandler {
	

	@SuppressWarnings({ "serial", "rawtypes", "unchecked" })
	@ExceptionHandler({ ValidationException.class })
	public ResponseEntity handleAll(Exception exception, WebRequest request) {
	Map<String, Object> res = CommonUtils.jsonToMap(exception.getMessage());
		 exception.getMessage();
		if(res.get(CommonConstants.ERRORS_KEY) != null) {
			res.put(CommonConstants.DATA_KEY, new HashMap<>() {{
				put(CommonConstants.ERRORS_KEY,res.get(CommonConstants.ERRORS_KEY));
			}});
			res.remove(CommonConstants.ERRORS_KEY);
		}
		return new ResponseEntity(res,HttpStatus.OK);
	}
	
	
	@SuppressWarnings({ "rawtypes", "unchecked", "serial" })

	@ExceptionHandler(value = Exception.class)
	public ResponseEntity exception(HttpServletRequest request, Exception exception) throws Exception {
		// HttpRequestMethodNotSupportedException exception.printStackTrace();
		if (exception instanceof HttpRequestMethodNotSupportedException)
			throw exception;
		Map<String, Object> res = CommonUtils.jsonToMap(exception.getMessage());
		if (res.get(CommonConstants.ERRORS_KEY) != null) {
			res.put(CommonConstants.DATA_KEY, new HashMap<>() {{
					put(CommonConstants.ERRORS_KEY, res.get("res"));
					put(CommonConstants.SUCCESS_KEY, false);
				}});
			res.remove(CommonConstants.ERRORS_KEY);
		}
		return new ResponseEntity(res, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	 
}
