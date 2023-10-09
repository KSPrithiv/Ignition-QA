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
public class OutboundTemperaturesDTO implements Serializable {
	@JsonProperty("outbound temperature 1")
	private String outboundTemperature1;
	@JsonProperty("outbound temperature 2")
	private String outboundTemperature2;
	@JsonProperty("outbound temperature 3")
	private String outboundTemperature3;
}