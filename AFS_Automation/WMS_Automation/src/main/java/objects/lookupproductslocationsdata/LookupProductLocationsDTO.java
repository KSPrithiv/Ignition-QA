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
public class LookupProductLocationsDTO implements Serializable {
	@JsonProperty("lookup owners")
	private LookupOwners lookupOwners;
	@JsonProperty("lookup dates")
	private LookupDates lookupDates;
	@JsonProperty("lookup exp dates")
	private LookupExpDates lookupExpDates;
	@JsonProperty("lookup products")
	private LookupProducts lookupProducts;
	@JsonProperty("lookup delete reasons")
	private LookupDeleteReasons lookupDeleteReasons;
	@JsonProperty("lookup trailers")
	private LookupTrailers lookupTrailers;
	@JsonProperty("lookup unit status reasons")
	private LookupUnitStatusReasons lookupUnitStatusReasons;
	@JsonProperty("lookup suppliers")
	private LookupSuppliers lookupSuppliers;
	@JsonProperty("lookup product staged")
	private LookupProductStaged lookupProductStaged;
	@JsonProperty("lookup labels")
	private LookupLabels lookupLabels;
	@JsonProperty("lookup product UOMs")
	private LookupProductUOMs lookupProductUOMs;
	@JsonProperty("lookup locations")
	private LookupLocations lookupLocations;
	@JsonProperty("lookup LPNs")
	private LookupLPNs lookupLPNs;
	@JsonProperty("lookup unit products")
	private LookupUnitProducts lookupUnitProducts;
	@JsonProperty("lookup UOMS")
	private LookupUOMS lookupUOMS;
	@JsonProperty("lookup product task types")
	private LookupProductTaskTypes lookupProductTaskTypes;
	@JsonProperty("lookup location types")
	private LookupLocationTypes lookupLocationTypes;
	@JsonProperty("lookup statuses")
	private LookupStatuses lookupStatuses;
}