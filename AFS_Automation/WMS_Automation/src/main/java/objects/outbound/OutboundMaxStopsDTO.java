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
public class OutboundMaxStopsDTO implements Serializable {
	@JsonProperty("outbound max stop 1")
	private String outboundMaxStop1;
	@JsonProperty("outbound max stop 2")
	private String outboundMaxStop2;
	@JsonProperty("outbound max stop 3")
	private String outboundMaxStop3;
}