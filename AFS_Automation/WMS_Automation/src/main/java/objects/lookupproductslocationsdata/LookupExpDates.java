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
public class LookupExpDates implements Serializable {
	@JsonProperty("lookup exp date 1")
	private String lookupExpDate1;
	@JsonProperty("lookup exp date 2")
	private String lookupExpDate2;
	@JsonProperty("lookup exp date 3")
	private String lookupExpDate3;
	@JsonProperty("lookup exp date 4")
	private String lookupExpDate4;
	@JsonProperty("lookup exp date 5")
	private String lookupExpDate5;
	@JsonProperty("lookup exp date 6")
	private String lookupExpDate6;
}