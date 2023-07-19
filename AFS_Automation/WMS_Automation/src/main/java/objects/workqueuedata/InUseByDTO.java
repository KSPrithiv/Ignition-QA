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
public class InUseByDTO implements Serializable {
	@JsonProperty("in use by 1")
	private String inUseBy1;
	@JsonProperty("in use by 2")
	private String inUseBy2;
}