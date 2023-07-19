package objects.countingcount;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UsersDTO implements Serializable {
	@JsonProperty("user 1")
	private String user1;
	@JsonProperty("user 2")
	private String user2;
	@JsonProperty("user 3")
	private String user3;
	@JsonProperty("user 4")
	private String user4;
	@JsonProperty("user 5")
	private String user5;
}