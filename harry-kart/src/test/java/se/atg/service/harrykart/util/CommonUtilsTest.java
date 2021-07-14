package se.atg.service.harrykart.util;



import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import junitparams.JUnitParamsRunner;

@RunWith(JUnitParamsRunner.class)
public class CommonUtilsTest {
	
	@InjectMocks
	private CommonUtils commonUtils = new CommonUtils();
	
	
	@SuppressWarnings("deprecation")
	@Before
	   public void Setup() {
			MockitoAnnotations.initMocks(this);
		   
	   }

	@SuppressWarnings("static-access")
	@Test
	public void testJsonToMap() throws JsonMappingException, JsonProcessingException {
		String value =  new ObjectMapper().writeValueAsString(new HashMap<>());
		assertNotNull(commonUtils.jsonToMap(value));		
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testJsonToMapforNull() throws JsonMappingException, JsonProcessingException {
		commonUtils.jsonToMap(null);		
	}
	
	
	@SuppressWarnings("static-access")
	@Test
	public void testMapToJson() throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> map = new HashMap<>();
		objectMapper.writeValueAsString(map);
		assertNotNull(commonUtils.mapToJson(map));
		}
	
	@SuppressWarnings("static-access")
	@Test
	public void testMapToJsonNull() throws JsonProcessingException {
		commonUtils.mapToJson(null);
		}
	
	
	
	
}
