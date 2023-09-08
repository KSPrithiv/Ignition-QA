package objects.inbound;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class InboundOrderLoadsDTO implements Serializable {
	@JsonProperty("start dates")
	private StartDatesDTO startDates;
	@JsonProperty("end dates")
	private EndDatesDTO endDates;
	@JsonProperty("product codes")
	private ProductCodesDTO productCodes;
	@JsonProperty("temperatures")
	private TemperaturesDTO temperatures;
	@JsonProperty("seal numbers")
	private SealNumbersDTO sealNumbers;
	@JsonProperty("load names")
	private LoadNamesDTO loadNames;
	@JsonProperty("order names")
	private InboundOrderNamesDTO orderNames;
	@JsonProperty("inbound carriers")
	private InboundCarriersDTO inboundCarriers;
	@JsonProperty("inbound load types")
	private InboundLoadTypesDTO inboundLoadTypes;
	@JsonProperty("inbound buyers")
	private InboundBuyersDTO inboundBuyers;
	@JsonProperty("inbound suppliers")
	private InboundSuppliersDTO inboundSuppliers;
	@JsonProperty("inbound customers")
	private InboundCustomersDTO inboundCustomers;
	@JsonProperty("inbound order types")
	private InboundOrderTypesDTO inboundOrderTypes;
}