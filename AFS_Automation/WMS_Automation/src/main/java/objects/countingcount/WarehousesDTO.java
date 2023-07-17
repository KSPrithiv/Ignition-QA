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
public class WarehousesDTO implements Serializable {
	@JsonProperty("warehouse 1")
	private String warehouse1;
	@JsonProperty("warehouse 2")
	private String warehouse2;
	@JsonProperty("warehouse 3")
	private String warehouse3;
	@JsonProperty("warehouse 4")
	private String warehouse4;
	@JsonProperty("warehouse 5")
	private String warehouse5;
}