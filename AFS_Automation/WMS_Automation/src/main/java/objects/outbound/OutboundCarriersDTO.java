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
public class OutboundCarriersDTO implements Serializable {
	@JsonProperty("outbound carrier 1")
	private String outboundCarrier1;
	@JsonProperty("outbound carrier 2")
	private String outboundCarrier2;
	@JsonProperty("outbound carrier 3")
	private String outboundCarrier3;
	@JsonProperty("outbound carrier 4")
	private String outboundCarrier4;
	@JsonProperty("outbound carrier 5")
	private String outboundCarrier5;
	@JsonProperty("outbound carrier 6")
	private String outboundCarrier6;
}