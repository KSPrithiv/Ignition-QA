package objects.inbound;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TemperaturesDTO implements Serializable {
	@JsonProperty("temperature 1")
	private String temperature1;
	@JsonProperty("temperature 2")
	private String temperature2;
	@JsonProperty("temperature 3")
	private String temperature3;
	@JsonProperty("temperature 4")
	private String temperature4;
	@JsonProperty("temperature 5")
	private String temperature5;
}