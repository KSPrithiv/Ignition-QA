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
public class InboundSuppliersDTO implements Serializable {
	@JsonProperty("inbound supplier 1")
	private String inboundSupplier1;
	@JsonProperty("inbound supplier 2")
	private String inboundSupplier2;
	@JsonProperty("inbound supplier 3")
	private String inboundSupplier3;
	@JsonProperty("inbound supplier 4")
	private String inboundSupplier4;
	@JsonProperty("inbound supplier 5")
	private String inboundSupplier5;
}