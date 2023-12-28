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
public class OutboundRoutesDTO implements Serializable {
	@JsonProperty("outbound route 1")
	private String outboundRoute1;
	@JsonProperty("outbound route 2")
	private String outboundRoute2;
	@JsonProperty("outbound route 3")
	private String outboundRoute3;
	@JsonProperty("outbound route 4")
	private String outboundRoute4;
	@JsonProperty("outbound route 5")
	private String outboundRoute5;
	@JsonProperty("outbound route 6")
	private String outboundRoute6;
	@JsonProperty("outbound route 7")
	private String outboundRoute7;

	@JsonProperty("outbound route 8")
	private String outboundRoute8;
	@JsonProperty("outbound route 9")
	private String outboundRoute9;
}