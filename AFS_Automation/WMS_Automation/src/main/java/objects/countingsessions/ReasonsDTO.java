package objects.countingsessions;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import java.io.Serializable;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ReasonsDTO implements Serializable {
	@JsonProperty("reason 1")
	private String reason1;
	@JsonProperty("reason 2")
	private int reason2;
	@JsonProperty("reason 3")
	private String reason3;
	@JsonProperty("reason 4")
	private String reason4;
}