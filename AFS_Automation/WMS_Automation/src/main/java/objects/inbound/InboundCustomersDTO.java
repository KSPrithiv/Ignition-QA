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
public class InboundCustomersDTO implements Serializable {
	@JsonProperty("inbound customer 1")
	private String inboundCustomer1;
	@JsonProperty("inbound customer 2")
	private String inboundCustomer2;
	@JsonProperty("inbound customer 3")
	private String inboundCustomer3;
}