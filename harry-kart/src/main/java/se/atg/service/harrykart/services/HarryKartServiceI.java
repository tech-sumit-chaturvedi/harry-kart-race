package se.atg.service.harrykart.services;

import org.springframework.stereotype.Service;

import se.atg.service.harrykart.model.HarryKartRequest;
import se.atg.service.harrykart.model.RankResponse;

@Service
public interface HarryKartServiceI {
	
	public RankResponse computeTop3Ranking(HarryKartRequest harryKartRequest);
}
