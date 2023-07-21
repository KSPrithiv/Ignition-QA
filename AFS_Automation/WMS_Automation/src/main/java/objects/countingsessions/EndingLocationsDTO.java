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
public class EndingLocationsDTO implements Serializable {
	@JsonProperty("ending location 1")
	private String endingLocation1;
	@JsonProperty("ending location 2")
	private String endingLocation2;
	@JsonProperty("ending location 3")
	private String endingLocation3;
	@JsonProperty("ending location 4")
	private String endingLocation4;
}