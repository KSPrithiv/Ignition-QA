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
public class TaskGroupDTO implements Serializable {
	@JsonProperty("task group 1")
	private String taskGroup1;
	@JsonProperty("task group 2")
	private String taskGroup2;
	@JsonProperty("task group 3")
	private String taskGroup3;
	@JsonProperty("task group 4")
	private String taskGroup4;
	@JsonProperty("task group 5")
	private String taskGroup5;
	@JsonProperty("task group 6")
	private String taskGroup6;
	@JsonProperty("task group 7")
	private String taskGroup7;
	@JsonProperty("task group 8")
	private String taskGroup8;
	@JsonProperty("task group 9")
	private String taskGroup9;
	@JsonProperty("task group 10")
	private String taskGroup10;
	@JsonProperty("task group 11")
	private String taskGroup11;
	@JsonProperty("task group 12")
	private String taskGroup12;
}