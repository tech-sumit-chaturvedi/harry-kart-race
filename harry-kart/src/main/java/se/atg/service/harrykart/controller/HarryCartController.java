package se.atg.service.harrykart.controller;

import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.log4j.Log4j2;
import se.atg.service.harrykart.base.BaseController;
import se.atg.service.harrykart.model.HarryKartRequest;
import se.atg.service.harrykart.model.RankResponse;
import se.atg.service.harrykart.services.HarryKartServiceI;
import se.atg.service.harrykart.validation.HarryKartValidation;

/**
 * This HarryCartController contains playHarryKart methods.
 * @author Sumit.Chaturvedi
 * @since 2021-11-07 20:23
 */
@Api(value = "RequestHandler", description = "This controller contains playHarryKart methods.")
@RestController
@RequestMapping("/api")
@Log4j2
public class HarryCartController extends BaseController{
	

@Autowired
private HarryKartServiceI harryKartServiceI;

/**
  @api {post} /api/play
  @apiGroup HarryKart
  @apiDescription Service to compute top 3 ranking.
  @apiParamExample {XML} Request-Payload:
	<harryKart>
	    <numberOfLoops>3</numberOfLoops>
	    <startList>
	        <participant>
	            <lane>1</lane>
	            <name>TIMETOBELUCKY</name>
	            <baseSpeed>10</baseSpeed>
	        </participant>
	        <participant>
	            <lane>2</lane>
	            <name>CARGO DOOR</name>
	            <baseSpeed>10</baseSpeed>
	        </participant>
	        <participant>
	            <lane>3</lane>
	            <name>HERCULES BOKO</name>
	            <baseSpeed>10</baseSpeed>
	        </participant>
	        <participant>
	            <lane>4</lane>
	            <name>WAIKIKI SILVIO</name>
	            <baseSpeed>10</baseSpeed>
	        </participant>
	    </startList>
	    <powerUps>
	        <loop number="1">
	            <lane number="1">1</lane>
	            <lane number="2">1</lane>
	            <lane number="3">0</lane>
	            <lane number="4">-2</lane>
	        </loop>
	        <loop number="2">
	            <lane number="1">1</lane>
	            <lane number="2">-1</lane>
	            <lane number="3">2</lane>
	            <lane number="4">-2</lane>
	        </loop>
	    </powerUps>
	</harryKart>

  @apiSuccessExample {json} Success-Response: 
  	HTTP/1.1 200 OK
  {
   "data": {
       "horse": [
           {
                "position": 1,
                "horse": "TIMETOBELUCKY"
           },
           {
                "position": 2,
                "horse": "HERCULES BOKO"
           },
           {
                "position": 3,
                "horse": "CARGO DOOR"
           }
       ]
    },
   "success": true
  }
  @apiSuccessExample {json} Error-Response: 
  	HTTP/1.1 200 OK
	{
	    "data": {
	        "errors": {
	            "Participant": "Required atleast two participant.",
	            "loops": "Number of loops value in the harryKartRequest XML does not match to the powerUps loops."
	        }
	    },
	    "success": false,
	    "message": "Unable to compute.",
	    "status": "BAD_REQUEST"
	}
  @author Sumit.Chaturvedi
  @since 2021-11-07 21:23
  @param harryKartRequest it contains representation of a Harry Kart race.
  @throws Exception when any exception occurs while computing top 3 ranking it will throw an exception.
  @see HarryKartService 
 */
@SuppressWarnings({ "rawtypes", "serial", "unchecked" })
@ApiOperation(value = "Compute top 3 Rank")
@PostMapping(value = "/play", consumes = "application/xml", produces = "application/json")
public ResponseEntity playHarryKart(@RequestBody HarryKartRequest harryKartRequest) throws Exception {
	log.info("HarryCartController :: playHarryKart() :: Invoked.");
	log.info("harryKartRequest in object format ::" + new ObjectMapper().writeValueAsString(harryKartRequest));
	HarryKartValidation.validateHarryKart(harryKartRequest);
	log.info("playHarryKart() :: harryKartRequest Data Validated Successfully");
	RankResponse  response = harryKartServiceI.computeTop3Ranking(harryKartRequest);
	log.info("HarryCartController :: playHarryKart() :: End.");
	return new ResponseEntity(new HashMap<String, Object>() {{
			put(DATA_KEY, response);
			put(SUCCESS_KEY, response != null ? true : false);
		}}, HttpStatus.OK);
}
}

