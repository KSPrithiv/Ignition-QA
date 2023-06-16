package objects.processedorderdata;

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
	@JsonProperty("productCode")
	private String productCode;
	@JsonProperty("productDescription")
	private String productDescription;
	@JsonProperty("count")
	private String count;
}