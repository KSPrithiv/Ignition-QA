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
public class TaskListVelocitiesDTO implements Serializable {
	@JsonProperty("task list velocity 1")
	private String taskListVelocity1;
	@JsonProperty("task list velocity 2")
	private String taskListVelocity2;
}