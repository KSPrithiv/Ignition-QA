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
public class ProductsDTO implements Serializable {
	@JsonProperty("product 1")
	private String product1;
	@JsonProperty("product 2")
	private String product2;
	@JsonProperty("product 3")
	private String product3;
	@JsonProperty("product 4")
	private String product4;
	@JsonProperty("product 5")
	private String product5;
}