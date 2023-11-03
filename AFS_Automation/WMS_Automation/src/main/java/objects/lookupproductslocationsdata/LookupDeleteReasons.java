package objects.lookupproductslocationsdata;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class LookupDeleteReasons implements Serializable {
	@JsonProperty("lookup delete reason 1")
	private String lookupDeleteReason1;
	@JsonProperty("lookup delete reason 2")
	private String lookupDeleteReason2;
	@JsonProperty("lookup delete reason 3")
	private String lookupDeleteReason3;
	@JsonProperty("lookup delete reason 4")
	private String lookupDeleteReason4;
	@JsonProperty("lookup delete reason 5")
	private String lookupDeleteReason5;
	@JsonProperty("lookup delete reason 6")
	private String lookupDeleteReason6;
}