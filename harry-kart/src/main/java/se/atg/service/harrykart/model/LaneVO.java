package se.atg.service.harrykart.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class LaneVO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@JacksonXmlProperty(isAttribute = true)
    private int number;

    @JacksonXmlText
    private int powerValue;


}
