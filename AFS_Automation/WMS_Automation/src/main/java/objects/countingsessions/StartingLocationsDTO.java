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
public class StartingLocationsDTO implements Serializable {
	@JsonProperty("starting location 1")
	private String startingLocation1;
	@JsonProperty("starting location 2")
	private String startingLocation2;
	@JsonProperty("starting location 3")
	private String startingLocation3;
	@JsonProperty("starting location 4")
	private String startingLocation4;
}