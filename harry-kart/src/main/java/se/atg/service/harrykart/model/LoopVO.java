package se.atg.service.harrykart.model;

import java.io.Serializable;
import java.util.List;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JacksonXmlRootElement(localName = "loop")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoopVO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@JacksonXmlProperty(isAttribute = true)
    private int number;

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "lane")
    private List<LaneVO> lanes;

   

}
