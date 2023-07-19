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
public class TaskListProductsDTO implements Serializable {
	@JsonProperty("task list product 1")
	private String taskListProduct1;
	@JsonProperty("task list product 2")
	private String taskListProduct2;
	@JsonProperty("task list product 3")
	private String taskListProduct3;
	@JsonProperty("task list product 4")
	private String taskListProduct4;
	@JsonProperty("task list product 5")
	private String taskListProduct5;
	@JsonProperty("task list product 6")
	private String taskListProduct6;
}