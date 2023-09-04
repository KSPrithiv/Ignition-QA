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
public class DescriptionsDTO implements Serializable {
	@JsonProperty("description 1")
	private String description1;
	@JsonProperty("description 2")
	private String description2;
	@JsonProperty("description 3")
	private String description3;
	@JsonProperty("description 4")
	private String description4;
	@JsonProperty("description 5")
	private String description5;
}