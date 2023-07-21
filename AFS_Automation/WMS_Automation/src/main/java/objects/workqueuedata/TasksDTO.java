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
public class TasksDTO implements Serializable {
	@JsonProperty("task 1")
	private String task1;
	@JsonProperty("task 2")
	private String task2;
	@JsonProperty("task 3")
	private String task3;
	@JsonProperty("task 4")
	private String task4;
	@JsonProperty("task 5")
	private String task5;
	@JsonProperty("task 6")
	private String task6;
}