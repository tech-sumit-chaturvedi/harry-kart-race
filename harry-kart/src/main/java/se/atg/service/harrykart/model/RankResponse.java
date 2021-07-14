package se.atg.service.harrykart.model;

import java.io.Serializable;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RankResponse implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private List<HorseVO> horse;

}