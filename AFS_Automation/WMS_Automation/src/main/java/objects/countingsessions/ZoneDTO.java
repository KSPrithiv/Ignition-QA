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
public class ZoneDTO implements Serializable {
    @JsonProperty("zone 1")
    private String zone1;
    @JsonProperty("zone 2")
    private String zone2;
    @JsonProperty("zone 3")
    private String zone3;
    @JsonProperty("zone 4")
    private String zone4;
    @JsonProperty("zone 5")
    private String zone5;
    @JsonProperty("zone 6")
    private String zone6;
}
