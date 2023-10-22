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
public class LookupProductUOMs implements Serializable {
	@JsonProperty("lookup product UOM 1")
	private String lookupProductUOM1;
	@JsonProperty("lookup product UOM 2")
	private String lookupProductUOM2;
}