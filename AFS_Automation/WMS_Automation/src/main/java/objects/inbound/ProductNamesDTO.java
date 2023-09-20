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
public class ProductNamesDTO implements Serializable {
	@JsonProperty("product name 1")
	private String productName1;
	@JsonProperty("product name 2")
	private String productName2;
	@JsonProperty("product name 3")
	private String productName3;
	@JsonProperty("product name 4")
	private String productName4;
	@JsonProperty("product name 5")
	private String productName5;
	@JsonProperty("product name 6")
	private String productName6;
}