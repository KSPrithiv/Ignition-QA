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
public class OutboundTemperatureTypesDTO implements Serializable {
	@JsonProperty("outbound temperature type 1")
	private String outboundTemperatureType1;
	@JsonProperty("outbound temperature type 2")
	private String outboundTemperatureType2;
	@JsonProperty("outbound temperature type 3")
	private String outboundTemperatureType3;
}