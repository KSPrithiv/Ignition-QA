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
public class LookupProductsDTO implements Serializable {
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
}