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
public class OutboundBatchesDTO implements Serializable {
	@JsonProperty("outbound batch 1")
	private String outboundBatch1;
	@JsonProperty("outbound batch 2")
	private String outboundBatch2;
	@JsonProperty("outbound batch 3")
	private String outboundBatch3;
}