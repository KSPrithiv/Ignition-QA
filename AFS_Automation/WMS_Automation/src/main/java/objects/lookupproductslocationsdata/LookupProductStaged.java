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
public class LookupProductStaged implements Serializable {
	@JsonProperty("lookup staged 1")
	private String lookupStaged1;
	@JsonProperty("lookup staged 2")
	private String lookupStaged2;
}