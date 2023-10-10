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
public class OutboundTopOffModalZonesDTO implements Serializable {
	@JsonProperty("outbound top off modal zone 1")
	private String outboundTopOffModalZone1;
	@JsonProperty("outbound top off modal zone 2")
	private String outboundTopOffModalZone2;
	@JsonProperty("outbound top off modal zone 3")
	private String outboundTopOffModalZone3;
}