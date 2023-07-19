package objects.countingsessions;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import java.io.Serializable;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class InventoryStatusesDTO implements Serializable {
	@JsonProperty("inventory status 1")
	private String inventoryStatus1;
	@JsonProperty("inventory status 2")
	private String inventoryStatus2;
	@JsonProperty("inventory status 3")
	private String inventoryStatus3;
	@JsonProperty("inventory status 4")
	private String inventoryStatus4;
	@JsonProperty("inventory status 5")
	private String inventoryStatus5;
	@JsonProperty("inventory status 6")
	private String inventoryStatus6;
}