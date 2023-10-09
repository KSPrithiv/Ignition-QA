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
public class OutboundProductsDTO implements Serializable {
	@JsonProperty("outbound product 1")
	private String outboundProduct1;
	@JsonProperty("outbound product 2")
	private String outboundProduct2;
	@JsonProperty("outbound product 3")
	private String outboundProduct3;
	@JsonProperty("outbound product 4")
	private String outboundProduct4;
	@JsonProperty("outbound product 5")
	private String outboundProduct5;
	@JsonProperty("outbound product 6")
	private String outboundProduct6;
}