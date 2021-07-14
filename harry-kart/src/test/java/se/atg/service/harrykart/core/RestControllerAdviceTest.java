package se.atg.service.harrykart.core;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.web.context.request.WebRequest;

import junitparams.JUnitParamsRunner;

@RunWith(JUnitParamsRunner.class)
public class RestControllerAdviceTest {
	
	@InjectMocks
	RestControllerAdvice advice = new RestControllerAdvice();
	
	
	@SuppressWarnings("deprecation")
	@Before
	   public void Setup() {
			MockitoAnnotations.initMocks(this);
		   
	}
	
	@Test(expected = Exception.class)
	public void testHandleAll() {
		advice.handleAll(new Exception("exception"), Mockito.mock(WebRequest.class));
		
	}
	

}
