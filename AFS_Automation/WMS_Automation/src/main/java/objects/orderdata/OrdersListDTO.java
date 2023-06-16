package objects.orderdata;

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
	@JsonProperty("orderNumber")
	private String orderNumber;
	@JsonProperty("altOrderNumber")
	private String altOrderNumber;
	@JsonProperty("warehouse")
	private String warehouse;
	@JsonProperty("source")
	private String source;
	@JsonProperty("orderType")
	private String orderType;
	@JsonProperty("qty")
	private String qty;
}