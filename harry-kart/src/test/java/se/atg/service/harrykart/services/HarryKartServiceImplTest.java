package se.atg.service.harrykart.services;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import junitparams.JUnitParamsRunner;
import se.atg.service.harrykart.model.HarryKartRequest;
import se.atg.service.harrykart.model.HorseVO;
import se.atg.service.harrykart.model.LaneVO;
import se.atg.service.harrykart.model.LoopVO;
import se.atg.service.harrykart.model.ParticipantVO;
import se.atg.service.harrykart.model.RankResponse;

@RunWith(JUnitParamsRunner.class)
public class HarryKartServiceImplTest  {
	
	
    @InjectMocks 
	private HarryKartServiceImpl service = new HarryKartServiceImpl();
	
	@Mock
	private double TRACK_LENGTH ;
	
	@Before
	public void setUP() {
		service = new HarryKartServiceImpl();
	}
	
   
	

	@SuppressWarnings("serial")
	@Test
	public void testComputeTop3Ranking() {
		RankResponse mockResponse = new RankResponse() {{
			setHorse(new ArrayList<HorseVO>() {{
				add(new HorseVO() {{
					setPosition(1);
				}});
			}});
		}};
		
		RankResponse actualResponse = service.computeTop3Ranking(new HarryKartRequest() {{
				setNumberOfLoops(1);
				setPowerUps(new ArrayList<LoopVO>() {{
						add(new LoopVO() {{
								setLanes(new ArrayList<LaneVO>() {{
										add(new LaneVO() {{
												setNumber(10);
											}});
									}});
							}});
					}});
				setStartList(new ArrayList<ParticipantVO>() {{
						add(new ParticipantVO() {{
								setLane(10);
								setTime(0.00);
								setBaseSpeed(10);
							}});
					}});
			}});
		assertNotNull(actualResponse);
		assertEquals(mockResponse, actualResponse);
	}
}


