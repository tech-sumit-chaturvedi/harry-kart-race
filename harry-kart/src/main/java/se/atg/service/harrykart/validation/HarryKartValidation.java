package se.atg.service.harrykart.validation;


import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.core.JsonProcessingException;

import lombok.extern.log4j.Log4j2;
import se.atg.service.harrykart.base.BaseController;
import se.atg.service.harrykart.exception.ValidationException;
import se.atg.service.harrykart.model.HarryKartRequest;
import se.atg.service.harrykart.util.CommonUtils;

/**
 * 
 * Validation for the HarryKart Request is performed here.
 * @author Sumit.Chaturvedi
 * @since 2021-11-07 20:23
 */
@Log4j2
public class HarryKartValidation {
	
	
	/**
	 * Validates the basic HarryKart given harryKartRequest 
	 * @author Sumit.Chaturedi
	 * @since 2021-11-07 21:23
	 * @param harryKartRequest
	 * @throws ValidationException 
	 * @throws Exception throws exception when validation fails
	 */
	@SuppressWarnings({ "rawtypes", "serial", "unchecked" })
	public static final void  validateHarryKart(HarryKartRequest harryKartRequest) throws JsonProcessingException, ValidationException {
		log.info("validateHarryKart()-------> validateHarryKart Method Invoked");
		Map<String, Object> msgs = new HashMap<>() {{
			if(harryKartRequest.getNumberOfLoops() != harryKartRequest.getPowerUps().size()+1) 
				put("loops", "Number of loops value in the harryKartRequest XML does not match to the powerUps loops.");
			if(harryKartRequest.getStartList().size() < 2 ) 
				put("Participant", "Atleast two participant required.");
		}};
			
		
		if(!msgs.isEmpty()) {
			Map<String, Object> errorMsgs = new HashMap<>() {{
				put(BaseController.SUCCESS_KEY, false);
				put(BaseController.STATUS, HttpStatus.BAD_REQUEST);
				put(BaseController.DATA_KEY,new HashMap() {{
					put(BaseController.ERRORS_KEY, msgs);
				}});
				put(BaseController.MESSAGE_KEY, "Unable to compute.");
			}};
			
			String json = CommonUtils.mapToJson(errorMsgs);
			throw new ValidationException(json);
		}
	}
	
}

