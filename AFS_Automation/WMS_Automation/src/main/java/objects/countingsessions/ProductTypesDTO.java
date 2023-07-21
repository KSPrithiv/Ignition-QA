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
public class ProductTypesDTO implements Serializable {
	@JsonProperty("product type 1")
	private String productType1;
	@JsonProperty("product type 2")
	private String productType2;
	@JsonProperty("product type 3")
	private String productType3;
	@JsonProperty("product type 4")
	private String productType4;
	@JsonProperty("product type 5")
	private String productType5;
	@JsonProperty("product type 6")
	private String productType6;
}