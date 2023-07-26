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
public class LookupSuppliersDTO implements Serializable {
	@JsonProperty("lookup supplier 1")
	private String lookupSupplier1;
	@JsonProperty("lookup supplier 2")
	private String lookupSupplier2;
	@JsonProperty("lookup supplier 3")
	private String lookupSupplier3;
	@JsonProperty("lookup supplier 4")
	private String lookupSupplier4;
	@JsonProperty("lookup supplier 5")
	private String lookupSupplier5;
	@JsonProperty("lookup supplier 6")
	private String lookupSupplier6;
}