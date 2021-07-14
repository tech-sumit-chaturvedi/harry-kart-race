package se.atg.service.harrykart.model;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HorseVO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int position;
    private String horse;

}
