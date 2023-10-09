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
public class EndDatesDTO implements Serializable {
	@JsonProperty("end date 1")
	private String endDate1;
	@JsonProperty("end date 2")
	private String endDate2;
	@JsonProperty("end date 3")
	private String endDate3;
	@JsonProperty("end date 4")
	private String endDate4;
	@JsonProperty("end date 5")
	private String endDate5;
	@JsonProperty("end date 6")
	private String endDate6;
}