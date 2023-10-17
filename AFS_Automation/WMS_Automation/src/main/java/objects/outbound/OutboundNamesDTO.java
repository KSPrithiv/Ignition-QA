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
public class OutboundNamesDTO implements Serializable {
	@JsonProperty("outbound name 1")
	private String outboundName1;
	@JsonProperty("outbound name 2")
	private String outboundName2;
	@JsonProperty("outbound name 3")
	private String outboundName3;
}