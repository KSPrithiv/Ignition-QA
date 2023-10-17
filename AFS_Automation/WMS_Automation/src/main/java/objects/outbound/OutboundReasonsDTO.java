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
public class OutboundReasonsDTO implements Serializable {
	@JsonProperty("outbound reason 1")
	private String outboundReason1;
	@JsonProperty("outbound reason 2")
	private String outboundReason2;
	@JsonProperty("outbound reason 3")
	private String outboundReason3;
	@JsonProperty("outbound reason 4")
	private String outboundReason4;
	@JsonProperty("outbound reason 5")
	private String outboundReason5;
	@JsonProperty("outbound reason 6")
	private String outboundReason6;
}