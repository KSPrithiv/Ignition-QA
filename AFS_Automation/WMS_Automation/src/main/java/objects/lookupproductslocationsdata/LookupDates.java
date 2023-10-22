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
public class LookupDates implements Serializable {
	@JsonProperty("lookup date 1")
	private String lookupDate1;
	@JsonProperty("lookup date 2")
	private String lookupDate2;
	@JsonProperty("lookup date 3")
	private String lookupDate3;
	@JsonProperty("lookup date 4")
	private String lookupDate4;
	@JsonProperty("lookup date 5")
	private String lookupDate5;
	@JsonProperty("lookup date 6")
	private String lookupDate6;
}