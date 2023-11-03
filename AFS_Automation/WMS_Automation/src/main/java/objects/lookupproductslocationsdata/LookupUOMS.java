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
public class LookupUOMS implements Serializable {
	@JsonProperty("lookup UOM 1")
	private String lookupUOM1;
	@JsonProperty("lookup UOM 2")
	private String lookupUOM2;
}