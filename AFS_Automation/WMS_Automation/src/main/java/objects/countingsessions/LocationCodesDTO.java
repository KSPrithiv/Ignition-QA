package objects.countingsessions;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import java.io.Serializable;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class LocationCodesDTO implements Serializable {
	@JsonProperty("location code 1")
	private String locationCode1;
	@JsonProperty("location code 2")
	private String locationCode2;
	@JsonProperty("location code 3")
	private String locationCode3;
	@JsonProperty("location code 4")
	private String locationCode4;
	@JsonProperty("location code 5")
	private String locationCode5;
	@JsonProperty("location code 6")
	private String locationCode6;
}