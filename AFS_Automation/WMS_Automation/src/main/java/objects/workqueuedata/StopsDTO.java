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
public class StopsDTO implements Serializable {
	@JsonProperty("stop 1")
	private String stop1;
	@JsonProperty("stop 2")
	private String stop2;
	@JsonProperty("stop 3")
	private String stop3;
	@JsonProperty("stop 4")
	private String stop4;
	@JsonProperty("stop 5")
	private String stop5;
	@JsonProperty("stop 6")
	private String stop6;
}