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
public class LookupOwnersDTO implements Serializable {
	@JsonProperty("lookup owner 1")
	private String lookupOwner1;
	@JsonProperty("lookup owner 2")
	private String lookupOwner2;
}