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
public class RemainingDTO implements Serializable {
	@JsonProperty("remaining 1")
	private String remaining1;
	@JsonProperty("remaining 2")
	private String remaining2;
	@JsonProperty("remaining 3")
	private String remaining3;
	@JsonProperty("remaining 4")
	private String remaining4;
	@JsonProperty("remaining 5")
	private String remaining5;
	@JsonProperty("remaining 6")
	private String remaining6;
}