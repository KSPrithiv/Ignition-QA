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
public class OutboundTrailersDTO implements Serializable {
	@JsonProperty("outbound trailer 1")
	private String outboundTrailer1;
	@JsonProperty("outbound trailer 2")
	private String outboundTrailer2;
	@JsonProperty("outbound trailer 3")
	private String outboundTrailer3;
	@JsonProperty("outbound trailer 4")
	private String outboundTrailer4;
	@JsonProperty("outbound trailer 5")
	private String outboundTrailer5;
	@JsonProperty("outbound trailer 6")
	private String outboundTrailer6;

	@JsonProperty("outbound trailer 7")
	private String outboundTrailer7;
}