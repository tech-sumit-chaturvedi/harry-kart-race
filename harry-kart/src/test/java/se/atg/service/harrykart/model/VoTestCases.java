package se.atg.service.harrykart.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

@RunWith(JUnitParamsRunner.class)
public class VoTestCases {
	
	

	@SuppressWarnings("serial")
	@Test
	public void harryKartRequestVOTest() {
		List<ParticipantVO> startList = new ArrayList<ParticipantVO>() {{
				add(new ParticipantVO());
			}};
			
	   List<LoopVO> powerUps = new ArrayList<LoopVO>();
			
		HarryKartRequest request = new HarryKartRequest() {{
				setNumberOfLoops(10);
				setStartList(startList);
				setPowerUps(new ArrayList<LoopVO>());
			}};
		HarryKartRequest allArgsConstTest = new HarryKartRequest(10, new ArrayList<ParticipantVO>(),
				new ArrayList<LoopVO>());
		request.toString();
		request.hashCode();
		request.canEqual(new Object());
		request.equals(request);
		
		assertEquals(request, request);
		assertEquals(allArgsConstTest, allArgsConstTest);
		assertEquals(10, request.getNumberOfLoops());
		assertEquals(startList, request.getStartList());
		assertEquals(powerUps, request.getPowerUps());

		EqualsVerifier.forClass(HarryKartRequest.class).suppress(Warning.STRICT_INHERITANCE)
				.suppress(Warning.NONFINAL_FIELDS);

	}	
	
	@SuppressWarnings("serial")
	@Test
	public void horseVOTest() {
		HorseVO horse = new HorseVO() {{
			setHorse("TIMETOBELUCKY");
			setPosition(1);
		}};
	
		new HorseVO(1, "TIMETOBELUCKY");  // Junit for @AllArgsConstructor
		horse.toString();
		horse.hashCode();
		horse.canEqual(horse);
		horse.equals(horse);
		
		assertEquals(horse, horse);
		assertEquals(1, horse.getPosition());
		assertEquals("TIMETOBELUCKY", horse.getHorse());
		
		EqualsVerifier.forClass(HorseVO.class).suppress(Warning.STRICT_INHERITANCE)
		.suppress(Warning.NONFINAL_FIELDS);
		
	}	
	
	@SuppressWarnings("serial")
	@Test
	public void laneVOTest() {
		LaneVO lane = new LaneVO() {{
			setNumber(1);
			setPowerValue(1);
		}};
		
		new LaneVO(1, 1);  // Junit for @AllArgsConstructor
		lane.toString();
		lane.hashCode();
		lane.canEqual(lane);
		lane.equals(lane);
		
		assertEquals(lane, lane);
		assertEquals(1, lane.getNumber());
		assertEquals(1, lane.getPowerValue());
		EqualsVerifier.forClass(LaneVO.class).suppress(Warning.STRICT_INHERITANCE)
		.suppress(Warning.NONFINAL_FIELDS);
		
	}	
	
	@SuppressWarnings("serial")
	@Test
	public void loopVOTest() {
		LoopVO loop = new LoopVO() {{
			setNumber(10);
			setLanes(new ArrayList<LaneVO>() {{
				add(new LaneVO());
			}});
		}};
		new LoopVO(0, new ArrayList<LaneVO>()); // junit for @AllArgsConstructor
		loop.toString();
		loop.hashCode();
		loop.canEqual(loop);
		loop.equals(loop);
		
		EqualsVerifier.forClass(LoopVO.class).suppress(Warning.STRICT_INHERITANCE)
		.suppress(Warning.NONFINAL_FIELDS);
		
	}
	
	@SuppressWarnings("serial")
	@Test
	public void rankResponseTest() {
		RankResponse response = new RankResponse() {{
			setHorse(new ArrayList<HorseVO>() {{
				add(new HorseVO() {{
					setPosition(1);
					setHorse("horse");
				}});
			}});
		}};
		new RankResponse(new ArrayList<HorseVO>() {{
			add(new HorseVO() {{
				setPosition(1);
				setHorse("horse");
			}});
		}});
			
		response.toString();
		response.hashCode();
		response.canEqual(response);
		response.equals(response);
		
		EqualsVerifier.forClass(RankResponse.class).suppress(Warning.STRICT_INHERITANCE)
		.suppress(Warning.NONFINAL_FIELDS);
		
	}
	
	
	@SuppressWarnings("serial")
	@Test
	public void participantVOTest() {
		ParticipantVO participantVO = new ParticipantVO() {{
			setName("sumit");
			setLane(5);
			setBaseSpeed(10);
			setTime(1000);
		}};
		participantVO.toString();
		participantVO.hashCode();
		participantVO.canEqual(participantVO);
		participantVO.equals(participantVO);
		
		participantVO.compareTo(new ParticipantVO() {{
			setTime(1000);
		}});
		participantVO.compareTo(new ParticipantVO() {{
			setTime(10);
		}});
		participantVO.compareTo(new ParticipantVO() {{
			setTime(10000);
		}});
		
		
		assertEquals(10, participantVO.getBaseSpeed());
		assertEquals("sumit", participantVO.getName());
		assertEquals(5, participantVO.getLane());
		assertEquals(1000, participantVO.getTime());
	
		EqualsVerifier.forClass(ParticipantVO.class).suppress(Warning.STRICT_INHERITANCE)
		.suppress(Warning.NONFINAL_FIELDS);
		
	}

}
