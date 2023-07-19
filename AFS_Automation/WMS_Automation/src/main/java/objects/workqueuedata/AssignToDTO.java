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
public class AssignToDTO implements Serializable {
	@JsonProperty("assign to 1")
	private String assignTo1;
	@JsonProperty("assign to 2")
	private String assignTo2;
	@JsonProperty("assign to 3")
	private String assignTo3;
	@JsonProperty("assign to 4")
	private String assignTo4;
	@JsonProperty("assign to 5")
	private String assignTo5;
}