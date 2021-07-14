package se.atg.service.harrykart.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;
import se.atg.service.harrykart.common.constant.CommonConstants;
import se.atg.service.harrykart.model.HarryKartRequest;
import se.atg.service.harrykart.model.HorseVO;
import se.atg.service.harrykart.model.LoopVO;
import se.atg.service.harrykart.model.ParticipantVO;
import se.atg.service.harrykart.model.RankResponse;
import se.atg.service.harrykart.util.CommonUtils;

/**
 * This HarryKartServiceImpl contains computeTop3Ranking() methods.
 * @author Sumit.Chaturvedi
 * @since 2021-12-07 17:23
 */
@Log4j2
@Service
public class HarryKartServiceImpl implements HarryKartServiceI {
    private static final double TRACK_LENGTH = 1000.00;

    
    /**
	 * This method is used to compute Top 3 Ranking.
	 * @param HarryKartRequest
	 * @return RankResponse
	 * @author Sumit.Chatuvedi
	 * @since 2021-13-07 02:12
	 */
	@SuppressWarnings("serial")
	@Override
	public RankResponse computeTop3Ranking(HarryKartRequest harryKartRequest) {
		log.info("HarryKartServiceImpl :: computeTop3Ranking() :: Invoked.");
		long startTime = CommonUtils.startTime();
		List<ParticipantVO> startList = harryKartRequest.getStartList();
		List<LoopVO> powerUps = harryKartRequest.getPowerUps();
		startList.forEach(s -> {
				s.setTime(TRACK_LENGTH/s.getBaseSpeed());
			powerUps.forEach(p -> {
				p.getLanes().forEach(f -> {
					if (f.getNumber() == s.getLane()) {
						s.setBaseSpeed(s.getBaseSpeed() + f.getPowerValue());
						s.setTime(s.getTime() + TRACK_LENGTH/s.getBaseSpeed());
					}
				});
			});
		});
		log.info("HarryKartServiceImpl :: computeTop3Ranking() :: forEachResponseTime ::" + CommonUtils.responseTime(startTime));
		Collections.sort(startList);
		log.info("computeTop3Ranking() :: based on time implemented default natural sorting order to sort startList.");
		List<ParticipantVO> top3Rank = startList.stream().limit(CommonConstants.THREE).collect(Collectors.toList());
		log.info("computeTop3Ranking() :: LIST CONTAINS TOP 3 RANKS :: "+ top3Rank);
		return new RankResponse() {
			int i = 0;
			{
				setHorse(new ArrayList<HorseVO>() {{
						top3Rank.forEach(p -> {
							add(new HorseVO() {{
									setPosition(++i);
									setHorse(p.getName());
						    }});
				        });
			   }});
		log.info("HarryKartServiceImpl :: computeTop3Ranking() :: End.");
		}};
		
		
	}
	
	
}


