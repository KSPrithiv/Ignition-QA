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
public class LookupProductTaskTypesDTO implements Serializable {
	@JsonProperty("lookup product task type 1")
	private String lookupProductTaskType1;
	@JsonProperty("lookup product task type 2")
	private String lookupProductTaskType2;
	@JsonProperty("lookup product task type 3")
	private String lookupProductTaskType3;
}