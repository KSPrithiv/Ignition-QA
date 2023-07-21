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
public class AssignmentNumbersDTO implements Serializable {
	@JsonProperty("assignment number 1")
	private String assignmentNumber1;
	@JsonProperty("assignment number 2")
	private String assignmentNumber2;
	@JsonProperty("assignment number 3")
	private String assignmentNumber3;
	@JsonProperty("assignment number 4")
	private String assignmentNumber4;
	@JsonProperty("assignment number 5")
	private String assignmentNumber5;
}