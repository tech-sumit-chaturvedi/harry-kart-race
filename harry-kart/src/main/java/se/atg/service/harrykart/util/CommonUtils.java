package se.atg.service.harrykart.util;

import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import lombok.extern.log4j.Log4j2;

/**
 * This class contains globally used methods.
 * @author Sumit.Chaturvedi
 * @since 2021-13-07 03:48
 *
 */

@Log4j2
public class CommonUtils {
	

	/**
	 * Converts the given input string to Map.
	 * @param String
	 * @return Map
	 * @author Sumit.Chaturvedi
	 * @since 2021-13-07 19:23
	 */
	@SuppressWarnings({ "unchecked"})
	public static Map<String, Object> jsonToMap(String s) {
		try {
			log.info("jsonToMap()-------> jsonToMap Method Invoked.");
			log.info("jsonToMap()-------> Convert Json To Map.");
			return new ObjectMapper().readValue(s, Map.class);
		} catch (Exception e) {
			log.error("Exception Occured while converting Json To Map", e);
			return null;
		}
	}
	
	/**
	 * Converts the requested Map to JSON.
	 * @param Map
	 * @return JSON String
	 * @author Sumit.Chaturvedi
	 * @since 2021-13-07 23:23
	 */
	
	public static String mapToJson(Map<String, Object> map) {
		try {
			log.info("mapToJson()-------> mapToJson Method Invoked.");
			log.info("mapToJson()-------> Convert Map To Json.");
			ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
			return ow.writeValueAsString(map);
		} catch (Exception e) {
			log.error("Exception Occured While Converting Map to Json", e);
			return null;
		}

	}
	
	public static long startTime() {
		return System.currentTimeMillis();
	}
	
	public static long responseTime(long startTime) {
		long responseTime = 0;
		if(startTime > 0) responseTime = (System.currentTimeMillis() - startTime)/1000;
		return responseTime;
		
		
	}
	
	
}
