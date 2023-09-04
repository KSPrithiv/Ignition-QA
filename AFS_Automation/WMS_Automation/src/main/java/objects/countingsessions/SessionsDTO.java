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
public class SessionsDTO implements Serializable {
	@JsonProperty("session 1")
	private String session1;
	@JsonProperty("session 2")
	private String session2;
	@JsonProperty("session 3")
	private String session3;
	@JsonProperty("session 4")
	private String session4;
	@JsonProperty("session 5")
	private String session5;
}