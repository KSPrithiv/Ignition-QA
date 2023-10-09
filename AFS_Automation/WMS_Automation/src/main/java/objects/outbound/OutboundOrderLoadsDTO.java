package objects.outbound;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class OutboundOrderLoadsDTO implements Serializable {
	@JsonProperty("start dates")
	private StartDatesDTO startDates;
	@JsonProperty("end dates")
	private EndDatesDTO endDates;
	@JsonProperty("outbound routes")
	private OutboundRoutesDTO outboundRoutes;
	@JsonProperty("outbound route codes")
	private OutboundRouteCodesDTO outboundRouteCodes;
	@JsonProperty("outbound reasons")
	private OutboundReasonsDTO outboundReasons;
	@JsonProperty("outbound orders")
	private OutboundOrdersDTO outboundOrders;
	@JsonProperty("load names")
	private LoadNamesDTO loadNames;
	@JsonProperty("outbound accounts")
	private OutboundAccountsDTO outboundAccounts;
	@JsonProperty("outbound order types")
	private OutboundOrderTypesDTO outboundOrderTypes;
	@JsonProperty("outbound products")
	private OutboundProductsDTO outboundProducts;
	@JsonProperty("outbound carriers")
	private OutboundCarriersDTO outboundCarriers;
	@JsonProperty("outbound trailers")
	private OutboundTrailersDTO outboundTrailers;
	@JsonProperty("outbound max stops")
	private OutboundMaxStopsDTO outboundMaxStops;
	@JsonProperty("outbound temperatures")
	private OutboundTemperaturesDTO outboundTemperatures;
	@JsonProperty("outbound temperature types")
	private OutboundTemperatureTypesDTO outboundTemperatureTypes;
	@JsonProperty("outbound top off modal zones")
	private OutboundTopOffModalZonesDTO outboundTopOffModalZones;
	@JsonProperty("outbound batches")
	private OutboundBatchesDTO outboundBatches;
	@JsonProperty("outbound names")
	private OutboundNamesDTO outboundNames;
}