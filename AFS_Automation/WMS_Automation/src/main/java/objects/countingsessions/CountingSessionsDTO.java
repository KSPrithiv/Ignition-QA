package objects.countingsessions;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import objects.countingcount.UsersDTO;

import java.io.Serializable;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CountingSessionsDTO implements Serializable {
	@JsonProperty("sessions")
	private SessionsDTO sessions;
	@JsonProperty("count types")
	private CountTypesDTO countTypes;
	@JsonProperty("location codes")
	private LocationCodesDTO locationCodes;
	@JsonProperty("location types")
	private LocationTypesDTO locationTypes;
	@JsonProperty("zones")
	private ZoneDTO zones;
	@JsonProperty("starting locations")
	private StartingLocationsDTO startingLocations;
	@JsonProperty("ending locations")
	private EndingLocationsDTO endingLocations;
	@JsonProperty("reasons")
	private ReasonsDTO reasons;
	@JsonProperty("products")
	private ProductsDTO products;
	@JsonProperty("product types")
	private ProductTypesDTO productTypes;
	@JsonProperty("owners")
	private OwnersDTO owners;
	@JsonProperty("descriptions")
	private DescriptionsDTO descriptions;
	@JsonProperty("movement classes")
	private MovementClassesDTO movementClasses;
	@JsonProperty("suppliers")
	private SuppliersDTO suppliers;
	@JsonProperty("prod alias types")
	private ProdAliasTypesDTO prodAliasTypes;
	@JsonProperty("inventory statuses")
	private InventoryStatusesDTO inventoryStatuses;
	@JsonProperty("users")
	private UsersDTO users;
}