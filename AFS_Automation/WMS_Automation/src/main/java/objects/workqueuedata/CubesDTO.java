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
public class CubesDTO implements Serializable {
	@JsonProperty("cube 1")
	private String cube1;
	@JsonProperty("cube 2")
	private String cube2;
	@JsonProperty("cube 3")
	private String cube3;
	@JsonProperty("cube 4")
	private String cube4;
	@JsonProperty("cube 5")
	private String cube5;
	@JsonProperty("cube 6")
	private String cube6;
}