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
public class LookupLPNsDTO implements Serializable {
	@JsonProperty("lookup LPN 1")
	private String lookupLPN1;
	@JsonProperty("lookup LPN 2")
	private String lookupLPN2;
	@JsonProperty("lookup LPN 3")
	private String lookupLPN3;
	@JsonProperty("lookup LPN 4")
	private String lookupLPN4;
	@JsonProperty("lookup LPN 5")
	private String lookupLPN5;
	@JsonProperty("lookup LPN 6")
	private String lookupLPN6;
	@JsonProperty("lookup LPN 7")
	private String lookupLPN7;
	@JsonProperty("lookup LPN 8")
	private String lookupLPN8;
}