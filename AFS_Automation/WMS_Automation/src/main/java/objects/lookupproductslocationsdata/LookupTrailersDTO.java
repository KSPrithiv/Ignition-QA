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
public class LookupTrailersDTO implements Serializable {
	@JsonProperty("lookup trailer 1")
	private String lookupDate1;
	@JsonProperty("lookup trailer 2")
	private String lookupDate2;
	@JsonProperty("lookup trailer 3")
	private String lookupDate3;
	@JsonProperty("lookup trailer 4")
	private String lookupDate4;
	@JsonProperty("lookup trailer 5")
	private String lookupDate5;
	@JsonProperty("lookup trailer 6")
	private String lookupDate6;
}