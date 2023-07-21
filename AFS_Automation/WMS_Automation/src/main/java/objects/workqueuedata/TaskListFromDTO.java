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
public class TaskListFromDTO implements Serializable {
	@JsonProperty("task list from 1")
	private String taskListFrom1;
	@JsonProperty("task list from 2")
	private String taskListFrom2;
	@JsonProperty("task list from 3")
	private String taskListFrom3;
	@JsonProperty("task list from 4")
	private String taskListFrom4;
	@JsonProperty("task list from 5")
	private String taskListFrom5;
	@JsonProperty("task list from 6")
	private String taskListFrom6;
}