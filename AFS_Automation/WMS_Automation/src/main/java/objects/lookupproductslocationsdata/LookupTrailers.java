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
public class LookupTrailers implements Serializable {
	@JsonProperty("lookup trailer 1")
	private String lookupTrailer1;
	@JsonProperty("lookup trailer 2")
	private String lookupTrailer2;
	@JsonProperty("lookup trailer 3")
	private String lookupTrailer3;
	@JsonProperty("lookup trailer 4")
	private String lookupTrailer4;
	@JsonProperty("lookup trailer 5")
	private String lookupTrailer5;
	@JsonProperty("lookup trailer 6")
	private String lookupTrailer6;
}