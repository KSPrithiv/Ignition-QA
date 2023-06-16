package objects.processedorderdata;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import java.io.Serializable;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class OrdersListDTO implements Serializable {
	@JsonProperty("order")
	private String order;
	@JsonProperty("source")
	private String source;
	@JsonProperty("products")
	private List<ProductsDTO> products;
}