package objects.workqueuedata;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class EstTimeDTO implements Serializable {
	@JsonProperty("est. time 1")
	private String estTime1;
	@JsonProperty("est. time 2")
	private String estTime2;
	@JsonProperty("est. time 3")
	private String estTime3;
	@JsonProperty("est. time 4")
	private String estTime4;
	@JsonProperty("est. time 5")
	private String estTime5;
	@JsonProperty("est. time 6")
	private String estTime6;
}