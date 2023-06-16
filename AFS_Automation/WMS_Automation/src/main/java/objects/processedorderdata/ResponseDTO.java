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
public class ResponseDTO implements Serializable {
	@JsonProperty("ordersList")
	private List<OrdersListDTO> ordersList;
}