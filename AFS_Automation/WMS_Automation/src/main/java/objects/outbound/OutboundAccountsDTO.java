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
public class OutboundAccountsDTO implements Serializable {
	@JsonProperty("outbound account 1")
	private String outboundAccount1;
	@JsonProperty("outbound account 2")
	private String outboundAccount2;
	@JsonProperty("outbound account 3")
	private String outboundAccount3;
	@JsonProperty("outbound account 4")
	private String outboundAccount4;
	@JsonProperty("outbound account 5")
	private String outboundAccount5;
	@JsonProperty("outbound account 6")
	private String outboundAccount6;
	@JsonProperty("outbound account 7")
	private String outboundAccount7;
}