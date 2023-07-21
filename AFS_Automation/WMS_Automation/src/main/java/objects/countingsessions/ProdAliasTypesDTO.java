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
public class ProdAliasTypesDTO implements Serializable {
	@JsonProperty("prod alias type 1")
	private String prodAliasType1;
	@JsonProperty("prod alias type 2")
	private String prodAliasType2;
	@JsonProperty("prod alias type 3")
	private String prodAliasType3;
	@JsonProperty("prod alias type 4")
	private String prodAliasType4;
	@JsonProperty("prod alias type 5")
	private String prodAliasType5;
}