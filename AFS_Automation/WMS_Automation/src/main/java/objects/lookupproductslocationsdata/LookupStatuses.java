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
public class LookupStatuses implements Serializable {
	@JsonProperty("lookup status 1")
	private String lookupStatus1;
	@JsonProperty("lookup status 2")
	private String lookupStatus2;
	@JsonProperty("lookup status 3")
	private String lookupStatus3;
	@JsonProperty("lookup status 4")
	private String lookupStatus4;
	@JsonProperty("lookup status 5")
	private String lookupStatus5;
	@JsonProperty("lookup status 6")
	private String lookupStatus6;
	@JsonProperty("lookup status 7")
	private String lookupStatus7;
}