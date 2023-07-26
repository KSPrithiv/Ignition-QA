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
public class LookupLabelsDTO implements Serializable {
	@JsonProperty("lookup label 1")
	private String lookupLabel1;
	@JsonProperty("lookup label 2")
	private String lookupLabel2;
	@JsonProperty("lookup label 3")
	private String lookupLabel3;
	@JsonProperty("lookup label 4")
	private String lookupLabel4;
	@JsonProperty("lookup label 5")
	private String lookupLabel5;
}