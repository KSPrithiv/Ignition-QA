package objects.countingcount;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CountingCountDTO implements Serializable {
	@JsonProperty("sessions")
	private SessionsDTO sessions;
	@JsonProperty("warehouses")
	private WarehousesDTO warehouses;
	@JsonProperty("location codes")
	private LocationCodesDTO locationCodes;
	@JsonProperty("UPC")
	private UPCDTO upc;
	@JsonProperty("UOM")
	private UOMDTO uom;
	@JsonProperty("products")
	private ProductsDTO products;
	@JsonProperty("users")
	private UsersDTO users;
	@JsonProperty("owners")
	private OwnersDTO owners;
	@JsonProperty("suppliers")
	private SuppliersDTO suppliers;
	@JsonProperty("product statuses")
	private ProductStatusesDTO productStatuses;
}