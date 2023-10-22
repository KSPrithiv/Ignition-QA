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
public class LookupProducts implements Serializable {
	@JsonProperty("lookup product 1")
	private String lookupProduct1;
	@JsonProperty("lookup product 2")
	private String lookupProduct2;
	@JsonProperty("lookup product 3")
	private String lookupProduct3;
	@JsonProperty("lookup product 4")
	private String lookupProduct4;
	@JsonProperty("lookup product 5")
	private String lookupProduct5;
	@JsonProperty("lookup product 6")
	private String lookupProduct6;
	@JsonProperty("lookup product 7")
	private String lookupProduct7;
}