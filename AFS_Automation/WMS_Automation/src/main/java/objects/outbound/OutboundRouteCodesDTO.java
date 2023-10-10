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
public class OutboundRouteCodesDTO implements Serializable {
	@JsonProperty("outbound route code 1")
	private String outboundRouteCode1;
	@JsonProperty("outbound route code 2")
	private String outboundRouteCode2;
	@JsonProperty("outbound route code 3")
	private String outboundRouteCode3;
	@JsonProperty("outbound route code 4")
	private String outboundRouteCode4;
	@JsonProperty("outbound route code 5")
	private String outboundRouteCode5;
	@JsonProperty("outbound route code 6")
	private String outboundRouteCode6;
}