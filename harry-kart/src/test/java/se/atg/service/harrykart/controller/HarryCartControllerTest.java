package se.atg.service.harrykart.controller;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import junitparams.JUnitParamsRunner;
import se.atg.service.harrykart.model.HarryKartRequest;
import se.atg.service.harrykart.model.LaneVO;
import se.atg.service.harrykart.model.LoopVO;
import se.atg.service.harrykart.model.ParticipantVO;
import se.atg.service.harrykart.services.HarryKartServiceI;
import se.atg.service.harrykart.services.HarryKartServiceImpl;

@RunWith(JUnitParamsRunner.class)
public class HarryCartControllerTest {

	@InjectMocks
	HarryCartController controller = new HarryCartController();

	@Mock
	private HarryKartServiceI harryKartServiceI = new HarryKartServiceImpl();

	@Mock
	private HarryKartServiceImpl harryKartServiceImpl = new HarryKartServiceImpl();
	
	@SuppressWarnings("deprecation")
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@SuppressWarnings("serial")
	@Test(expected = Exception.class)
	public void testPlayHarryKart() throws Exception {

		HarryKartRequest harryKartRequest = new HarryKartRequest() {
			{
				setNumberOfLoops(7);
				setPowerUps(new ArrayList<LoopVO>() {
					{
						add(new LoopVO() {
							{
								setLanes(new ArrayList<LaneVO>() {
									{
										add(new LaneVO() {
											{
												setNumber(10);
											}
										});
									}
								});
							}
						});
						add(new LoopVO() {
							{
								setLanes(new ArrayList<LaneVO>() {
									{
										add(new LaneVO() {
											{
												setNumber(10);
											}
										});
									}
								});
							}
						});
					}
				});
				setStartList(new ArrayList<ParticipantVO>() {
					{
						add(new ParticipantVO() {
							{
								setLane(10);
								setTime(0.00);
								setBaseSpeed(10);
							}
						});
					}
				});
			}
		};
		controller.playHarryKart(harryKartRequest);
	}
}
