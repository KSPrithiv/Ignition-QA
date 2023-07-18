package objects.workqueuedata;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ShippersDTO implements Serializable {
	@JsonProperty("shipper 1")
	private String shipper1;
	@JsonProperty("shipper 2")
	private String shipper2;
	@JsonProperty("shipper 3")
	private String shipper3;
	@JsonProperty("shipper 4")
	private String shipper4;
	@JsonProperty("shipper 5")
	private String shipper5;
	@JsonProperty("shipper 6")
	private String shipper6;
}