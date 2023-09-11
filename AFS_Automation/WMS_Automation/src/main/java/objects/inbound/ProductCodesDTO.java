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
public class ProductCodesDTO implements Serializable {
	@JsonProperty("product code 1")
	private String productCode1;
	@JsonProperty("product code 2")
	private String productCode2;
	@JsonProperty("product code 3")
	private String productCode3;
	@JsonProperty("product code 4")
	private String productCode4;
	@JsonProperty("product code 5")
	private String productCode5;
}