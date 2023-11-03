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
public class LookupLocations implements Serializable {
	@JsonProperty("lookup location 1")
	private String lookupLocation1;
	@JsonProperty("lookup location 2")
	private String lookupLocation2;
	@JsonProperty("lookup location 3")
	private String lookupLocation3;
	@JsonProperty("lookup location 4")
	private String lookupLocation4;
	@JsonProperty("lookup location 5")
	private String lookupLocation5;
	@JsonProperty("lookup location 6")
	private String lookupLocation6;
}