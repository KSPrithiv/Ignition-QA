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
public class RoutesDTO implements Serializable {
	@JsonProperty("route 1")
	private String route1;
	@JsonProperty("route 2")
	private String route2;
	@JsonProperty("route 3")
	private String route3;
	@JsonProperty("route 4")
	private String route4;
	@JsonProperty("route 5")
	private String route5;
	@JsonProperty("route 6")
	private String route6;
}