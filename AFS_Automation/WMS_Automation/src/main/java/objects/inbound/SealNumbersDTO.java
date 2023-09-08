package objects.inbound;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SealNumbersDTO implements Serializable {
	@JsonProperty("seal number 1")
	private String sealNumber1;
	@JsonProperty("seal number 2")
	private String sealNumber2;
	@JsonProperty("seal number 3")
	private String sealNumber3;
	@JsonProperty("seal number 4")
	private String sealNumber4;
	@JsonProperty("seal number 5")
	private String sealNumber5;
	@JsonProperty("seal number 6")
	private String sealNumber6;
}