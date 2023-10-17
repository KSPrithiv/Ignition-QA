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
public class InboundBuyersDTO implements Serializable {
	@JsonProperty("inbound buyer 1")
	private String inboundBuyer1;
	@JsonProperty("inbound buyer 2")
	private String inboundBuyer2;
	@JsonProperty("inbound buyer 3")
	private String inboundBuyer3;
	@JsonProperty("inbound buyer 4")
	private String inboundBuyer4;
	@JsonProperty("inbound buyer 5")
	private String inboundBuyer5;
}