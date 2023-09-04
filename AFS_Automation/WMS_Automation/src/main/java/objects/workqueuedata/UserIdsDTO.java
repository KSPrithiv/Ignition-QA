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
public class UserIdsDTO implements Serializable {
	@JsonProperty("user id 1")
	private String userId1;
	@JsonProperty("user id 2")
	private String userId2;
	@JsonProperty("user id 3")
	private String userId3;
	@JsonProperty("user id 4")
	private String userId4;
	@JsonProperty("user id 5")
	private String userId5;
	@JsonProperty("user id 6")
	private String userId6;
}