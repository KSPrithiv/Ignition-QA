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
public class CountTypesDTO implements Serializable {
	@JsonProperty("count type 1")
	private String countType1;
	@JsonProperty("count type 2")
	private String countType2;
	@JsonProperty("count type 3")
	private String countType3;
	@JsonProperty("count type 4")
	private String countType4;
}