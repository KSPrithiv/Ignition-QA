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
public class MovementClassesDTO implements Serializable {
	@JsonProperty("movement class 1")
	private String movementClass1;
	@JsonProperty("movement class 2")
	private String movementClass2;
	@JsonProperty("movement class 3")
	private String movementClass3;
	@JsonProperty("movement class 4")
	private String movementClass4;
	@JsonProperty("movement class 5")
	private String movementClass5;
}