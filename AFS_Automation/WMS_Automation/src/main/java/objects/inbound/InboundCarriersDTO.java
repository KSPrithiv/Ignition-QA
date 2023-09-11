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
public class InboundCarriersDTO implements Serializable {
	@JsonProperty("inbound carrier 1")
	private String inboundCarrier1;
	@JsonProperty("inbound carrier 2")
	private String inboundCarrier2;
	@JsonProperty("inbound carrier 3")
	private String inboundCarrier3;
	@JsonProperty("inbound carrier 4")
	private String inboundCarrier4;
	@JsonProperty("inbound carrier 5")
	private String inboundCarrier5;
}