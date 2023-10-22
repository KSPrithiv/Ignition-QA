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
public class LookupUnitProducts implements Serializable {
	@JsonProperty("lookup unit product 1")
	private String lookupUnitProduct1;
	@JsonProperty("lookup unit product 2")
	private String lookupUnitProduct2;
	@JsonProperty("lookup unit product 3")
	private String lookupUnitProduct3;
	@JsonProperty("lookup unit product 4")
	private String lookupUnitProduct4;
	@JsonProperty("lookup unit product 5")
	private String lookupUnitProduct5;
	@JsonProperty("lookup unit product 6")
	private String lookupUnitProduct6;
	@JsonProperty("lookup unit product 7")
	private String lookupUnitProduct7;
	@JsonProperty("lookup unit product 8")
	private String lookupUnitProduct8;
	@JsonProperty("lookup unit product 9")
	private String lookupUnitProduct9;
}