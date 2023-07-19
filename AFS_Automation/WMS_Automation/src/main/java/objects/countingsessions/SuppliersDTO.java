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
public class SuppliersDTO implements Serializable {
	@JsonProperty("supplier 1")
	private String supplier1;
	@JsonProperty("supplier 2")
	private String supplier2;
	@JsonProperty("supplier 3")
	private String supplier3;
	@JsonProperty("supplier 4")
	private String supplier4;
	@JsonProperty("supplier 5")
	private String supplier5;
}