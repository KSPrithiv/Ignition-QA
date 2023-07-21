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
public class LocationTypesDTO implements Serializable {
	@JsonProperty("location type 1")
	private String locationType1;
	@JsonProperty("location type 2")
	private String locationType2;
	@JsonProperty("location type 3")
	private String locationType3;
	@JsonProperty("location type 4")
	private String locationType4;
	@JsonProperty("location type 5")
	private String locationType5;
}