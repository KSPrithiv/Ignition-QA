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
public class QtiesDTO implements Serializable {
	@JsonProperty("qty 1")
	private String qty1;
	@JsonProperty("qty 2")
	private String qty2;
	@JsonProperty("qty 3")
	private String qty3;
	@JsonProperty("qty 4")
	private String qty4;
	@JsonProperty("qty 5")
	private String qty5;
	@JsonProperty("qty 6")
	private String qty6;
}