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
public class ComputersDTO implements Serializable {
	@JsonProperty("computer 1")
	private String computer1;
	@JsonProperty("computer 2")
	private String computer2;
	@JsonProperty("computer 3")
	private String computer3;
	@JsonProperty("computer 4")
	private String computer4;
	@JsonProperty("computer 5")
	private String computer5;
	@JsonProperty("computer 6")
	private String computer6;
}