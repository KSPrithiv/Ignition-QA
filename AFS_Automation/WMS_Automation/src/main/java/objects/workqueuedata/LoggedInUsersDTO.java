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
public class LoggedInUsersDTO implements Serializable {
	@JsonProperty("logged-in user 1")
	private String loggedInUser1;
	@JsonProperty("logged-in user 2")
	private String loggedInUser2;
	@JsonProperty("logged-in user 3")
	private String loggedInUser3;
	@JsonProperty("logged-in user 4")
	private String loggedInUser4;
	@JsonProperty("logged-in user 5")
	private String loggedInUser5;
	@JsonProperty("logged-in user 6")
	private String loggedInUser6;
}