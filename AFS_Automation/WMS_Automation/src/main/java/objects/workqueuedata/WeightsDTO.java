package objects.workqueuedata;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.annotation.Generated;
import java.io.Serializable;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class WeightsDTO implements Serializable {
	@JsonProperty("weight 1")
	private String weight1;
	@JsonProperty("weight 2")
	private String weight2;
	@JsonProperty("weight 3")
	private String weight3;
	@JsonProperty("weight 4")
	private String weight4;
	@JsonProperty("weight 5")
	private String weight5;
	@JsonProperty("weight 6")
	private String weight6;
}