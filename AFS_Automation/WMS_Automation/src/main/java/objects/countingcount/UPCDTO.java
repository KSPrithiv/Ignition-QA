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
public class UPCDTO implements Serializable {
	@JsonProperty("UPC 1")
	private String uPC1;
	@JsonProperty("UPC 2")
	private String uPC2;
	@JsonProperty("UPC 3")
	private String uPC3;
	@JsonProperty("UPC 4")
	private String uPC4;
	@JsonProperty("UPC 5")
	private String uPC5;
	@JsonProperty("UPC 6")
	private String uPC6;
}