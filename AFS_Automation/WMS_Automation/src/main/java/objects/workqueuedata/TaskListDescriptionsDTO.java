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
public class TaskListDescriptionsDTO implements Serializable {
	@JsonProperty("task list description 1")
	private String taskListDescription1;
	@JsonProperty("task list description 2")
	private String taskListDescription2;
	@JsonProperty("task list description 3")
	private String taskListDescription3;
	@JsonProperty("task list description 4")
	private String taskListDescription4;
	@JsonProperty("task list description 5")
	private String taskListDescription5;
	@JsonProperty("task list description 6")
	private String taskListDescription6;
}