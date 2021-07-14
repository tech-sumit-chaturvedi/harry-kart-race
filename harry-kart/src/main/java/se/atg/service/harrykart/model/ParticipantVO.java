package se.atg.service.harrykart.model;


import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

@JacksonXmlRootElement(localName = "participant")
@JsonIgnoreProperties(value = { "time" })
@Data
public class ParticipantVO implements Serializable, Comparable< ParticipantVO >{
	
	private static final long serialVersionUID = 1L;

	@JsonProperty
    private int lane;

    @JacksonXmlProperty
    private String name;

    @JacksonXmlProperty
    private int baseSpeed;
    
    private double time;

    //implemented default natural sorting order based on the time.
	@Override
	public int compareTo(ParticipantVO other) {
		if (this.getTime() == other.getTime()) return 0;
		else if (this.getTime() > other.getTime()) return 1;
		else return -1;
	}
}
