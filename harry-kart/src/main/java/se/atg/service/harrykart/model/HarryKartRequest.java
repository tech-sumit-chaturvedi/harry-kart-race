package se.atg.service.harrykart.model;

import java.io.Serializable;
import java.util.List;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JacksonXmlRootElement(localName = "harryKart")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HarryKartRequest implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int numberOfLoops;
	private List<ParticipantVO> startList;
    private List<LoopVO> powerUps;

   
}
