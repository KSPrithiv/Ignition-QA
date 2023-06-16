package objects.orderdata;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ProcessingOrderDTO {
    private String order;
    private String shipDate;
    private String source;
    private String description;

}
