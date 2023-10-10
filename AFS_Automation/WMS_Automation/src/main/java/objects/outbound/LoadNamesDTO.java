package objects.outbound;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class LoadNamesDTO implements Serializable {
	@JsonProperty("load name 1")
	private String loadName1;
	@JsonProperty("load name 2")
	private String loadName2;
	@JsonProperty("load name 3")
	private String loadName3;
	@JsonProperty("load name 4")
	private String loadName4;
	@JsonProperty("load name 5")
	private String loadName5;
	@JsonProperty("load name 6")
	private String loadName6;
}