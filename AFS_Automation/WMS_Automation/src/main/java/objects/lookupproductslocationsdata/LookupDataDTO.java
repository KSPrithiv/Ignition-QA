package objects.lookupproductslocationsdata;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class LookupDataDTO implements Serializable {
	@JsonProperty("lookup dates")
	private LookupDatesDTO lookupDatesDTO
			;


	@JsonProperty("lookup locations")
	private LookupLocationsDTO lookupLocations;
	@JsonProperty("lookup LPNs")
	private LookupLPNsDTO lookupLPNs;
	@JsonProperty("lookup labels")
	private LookupLabelsDTO lookupLabels;
	@JsonProperty("lookup delete reasons")
	private LookupDeleteReasonsDTO lookupDeleteReasons;
	@JsonProperty("lookup statuses")
	private LookupStatusesDTO lookupStatuses;
	@JsonProperty("lookup unit status reasons")
	private LookupUnitStatusReasonsDTO lookupUnitStatusReasons;
	@JsonProperty("lookup unit products")
	private LookupUnitProductsDTO lookupUnitProducts;
	@JsonProperty("lookup owners")
	private LookupOwnersDTO lookupOwners;
	@JsonProperty("lookup suppliers")
	private LookupSuppliersDTO lookupSuppliers;
	@JsonProperty("lookup UOMS")
	private LookupUOMSDTO lookupUOMS;
	@JsonProperty("lookup products")
	private LookupProductsDTO lookupProducts;
	@JsonProperty("lookup product UOMs")
	private LookupProductUOMsDTO lookupProductUOMs;
	@JsonProperty("lookup product task types")
	private LookupProductTaskTypesDTO lookupProductTaskTypes;
	@JsonProperty("lookup location types")
	private LookupLocationTypesDTO lookupLocationTypes;
	@JsonProperty("lookup product staged")
	private LookupProductStagedDTO lookupProductStaged;
}