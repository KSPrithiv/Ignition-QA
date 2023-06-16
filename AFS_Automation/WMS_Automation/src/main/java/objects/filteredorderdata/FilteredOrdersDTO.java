package objects.filteredorderdata;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class FilteredOrdersDTO implements Serializable {
	@JsonProperty("Order")
	private String order;

	@JsonProperty("ShipDate")
	private String shipDate;

	@JsonProperty("Source")
	private String source;

	@JsonProperty("Description")
	private String description;

	@JsonProperty("Company")
	private String company;

	@JsonProperty("SourceCity")
	private String sourceCity;

	@JsonProperty("OrderType")
	private String orderType;

	@JsonProperty("Owner")
	private String owner;

	@JsonProperty("OwnerName")
	private String ownerName;

	@JsonProperty("Quantity")
	private int quantity;

	@JsonProperty("Cube")
	private int cube;

	@JsonProperty("Batch")
	private String batch;
}