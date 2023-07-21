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
public class TaskListToDTO implements Serializable {
	@JsonProperty("task list to 1")
	private String taskListTo1;
	@JsonProperty("task list to 2")
	private String taskListTo2;
	@JsonProperty("task list to 3")
	private String taskListTo3;
	@JsonProperty("task list to 4")
	private String taskListTo4;
	@JsonProperty("task list to 5")
	private String taskListTo5;
	@JsonProperty("task list to 6")
	private String taskListTo6;
}