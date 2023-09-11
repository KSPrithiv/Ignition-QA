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
public class InboundOrderNamesDTO implements Serializable {
    @JsonProperty("order name 1")
    private String orderName1;
    @JsonProperty("order name 2")
    private String orderName2;
    @JsonProperty("order name 3")
    private String orderName3;
    @JsonProperty("order name 4")
    private String orderName4;
    @JsonProperty("order name 5")
    private String orderName5;
    @JsonProperty("order name 6")
    private String orderName6;
    @JsonProperty("order name 7")
    private String orderName7;
}
