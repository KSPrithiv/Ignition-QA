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
public class PickedDTO implements Serializable {
	@JsonProperty("% picked 1")
	private String picked1;
	@JsonProperty("% picked 2")
	private String picked2;
}