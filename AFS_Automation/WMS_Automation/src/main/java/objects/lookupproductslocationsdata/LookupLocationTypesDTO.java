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
public class LookupLocationTypesDTO implements Serializable {
	@JsonProperty("lookup location type 1")
	private String lookupLocationType1;
	@JsonProperty("lookup location type 2")
	private String lookupLocationType2;
	@JsonProperty("lookup location type 3")
	private String lookupLocationType3;
}