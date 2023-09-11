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
public class InboundOrderTypesDTO implements Serializable {
	@JsonProperty("inbound order type 1")
	private String inboundOrderType1;
	@JsonProperty("inbound order type 2")
	private String inboundOrderType2;
	@JsonProperty("inbound order type 3")
	private String inboundOrderType3;
	@JsonProperty("inbound order type 4")
	private String inboundOrderType4;
	@JsonProperty("inbound order type 5")
	private String inboundOrderType5;
	@JsonProperty("inbound order type 6")
	private String inboundOrderType6;
	@JsonProperty("inbound order type 7")
	private String inboundOrderType7;
}