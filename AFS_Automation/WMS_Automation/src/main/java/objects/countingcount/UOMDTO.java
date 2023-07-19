package objects.countingcount;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UOMDTO implements Serializable {
	@JsonProperty("UOM 1")
	private String uom1;
	@JsonProperty("UOM 2")
	private String uom2;
	@JsonProperty("UOM 3")
	private String uom3;
	@JsonProperty("UOM 4")
	private String uom4;
}