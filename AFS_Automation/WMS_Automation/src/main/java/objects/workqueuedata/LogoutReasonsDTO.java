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
public class LogoutReasonsDTO implements Serializable {
	@JsonProperty("logout reason 1")
	private String logoutReason1;
	@JsonProperty("logout reason 2")
	private String logoutReason2;
	@JsonProperty("logout reason 3")
	private String logoutReason3;
	@JsonProperty("logout reason 4")
	private String logoutReason4;
}