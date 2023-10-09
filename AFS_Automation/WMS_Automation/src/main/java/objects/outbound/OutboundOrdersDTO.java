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
public class OutboundOrdersDTO implements Serializable {
	@JsonProperty("outbound order 1")
	private String outboundOrder1;
	@JsonProperty("outbound order 2")
	private String outboundOrder2;
	@JsonProperty("outbound order 3")
	private String outboundOrder3;
	@JsonProperty("outbound order 4")
	private String outboundOrder4;
	@JsonProperty("outbound order 5")
	private String outboundOrder5;
	@JsonProperty("outbound order 6")
	private String outboundOrder6;
	@JsonProperty("outbound order 7")
	private String outboundOrder7;
}