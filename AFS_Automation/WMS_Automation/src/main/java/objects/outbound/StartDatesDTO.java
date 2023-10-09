package objects.outbound;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class StartDatesDTO implements Serializable {
	@JsonProperty("start date 1")
	private String startDate1;
	@JsonProperty("start date 2")
	private String startDate2;
	@JsonProperty("start date 3")
	private String startDate3;
	@JsonProperty("start date 4")
	private String startDate4;
	@JsonProperty("start date 5")
	private String startDate5;
	@JsonProperty("start date 6")
	private String startDate6;
	@JsonProperty("start date 7")
	private String startDate7;
}