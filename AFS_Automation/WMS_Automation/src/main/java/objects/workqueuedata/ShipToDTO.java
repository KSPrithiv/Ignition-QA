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
public class ShipToDTO implements Serializable {
	@JsonProperty("ship to 1")
	private String shipTo1;
	@JsonProperty("ship to 2")
	private String shipTo2;
	@JsonProperty("ship to 3")
	private String shipTo3;
	@JsonProperty("ship to 4")
	private String shipTo4;
	@JsonProperty("ship to 5")
	private String shipTo5;
	@JsonProperty("ship to 6")
	private String shipTo6;
}