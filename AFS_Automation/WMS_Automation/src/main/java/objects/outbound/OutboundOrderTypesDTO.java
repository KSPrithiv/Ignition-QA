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
public class OutboundOrderTypesDTO implements Serializable {
	@JsonProperty("outbound order type 1")
	private String outboundOrderType1;
	@JsonProperty("outbound order type 2")
	private String outboundOrderType2;
	@JsonProperty("outbound order type 3")
	private String outboundOrderType3;
	@JsonProperty("outbound order type 4")
	private String outboundOrderType4;
	@JsonProperty("outbound order type 5")
	private String outboundOrderType5;
	@JsonProperty("outbound order type 6")
	private String outboundOrderType6;
}