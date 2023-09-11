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
public class InboundLoadTypesDTO implements Serializable {
	@JsonProperty("inbound load type 1")
	private String inboundLoadType1;
	@JsonProperty("inbound load type 2")
	private String inboundLoadType2;
	@JsonProperty("inbound load type 3")
	private String inboundLoadType3;
}