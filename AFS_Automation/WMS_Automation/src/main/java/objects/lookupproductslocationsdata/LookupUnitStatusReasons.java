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
public class LookupUnitStatusReasons implements Serializable {
	@JsonProperty("lookup unit status reason 1")
	private String lookupUnitStatusReason1;
	@JsonProperty("lookup unit status reason 2")
	private String lookupUnitStatusReason2;
	@JsonProperty("lookup unit status reason 3")
	private String lookupUnitStatusReason3;
	@JsonProperty("lookup unit status reason 4")
	private String lookupUnitStatusReason4;
	@JsonProperty("lookup unit status reason 5")
	private String lookupUnitStatusReason5;
}