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
public class TaskListStatusDTO implements Serializable {
	@JsonProperty("task list status 1")
	private String taskListStatus1;
	@JsonProperty("task list status 2")
	private String taskListStatus2;
	@JsonProperty("task list status 3")
	private String taskListStatus3;
	@JsonProperty("task list status 4")
	private String taskListStatus4;
	@JsonProperty("task list status 5")
	private String taskListStatus5;
	@JsonProperty("task list status 6")
	private String taskListStatus6;
}