package objects.orderdata;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;
import java.io.Serializable;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDTO implements Serializable {
	@JsonProperty("ordersList")
	private List<OrdersListDTO> ordersList;
	@JsonProperty("linkedOrdersList")
	private List<LinkedOrdersListDTO> linkedOrdersList;
}