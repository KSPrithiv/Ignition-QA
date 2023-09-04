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
public class OwnersDTO implements Serializable {
	@JsonProperty("owner 1")
	private String owner1;
	@JsonProperty("owner 2")
	private String owner2;
	@JsonProperty("owner 3")
	private String owner3;
	@JsonProperty("owner 4")
	private String owner4;
	@JsonProperty("owner 5")
	private String owner5;
}