package objects.orderdata;

import lombok.*;

import java.util.List;
import java.io.Serializable;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class LinkedOrdersListDTO implements Serializable {
	private String linkedOrderNumber;
	private List<LinkedOrdersDTO> linkedOrders;
}