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
public class TaskListPrioritiesDTO implements Serializable {
	@JsonProperty("task list priority 1")
	private String taskListPriority1;
	@JsonProperty("task list priority 2")
	private String taskListPriority2;
	@JsonProperty("task list priority 3")
	private String taskListPriority3;
}