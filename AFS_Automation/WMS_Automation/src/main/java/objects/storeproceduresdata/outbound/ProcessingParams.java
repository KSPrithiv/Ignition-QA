package objects.storeproceduresdata.outbound;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ProcessingParams {
    private int all_orders;
    private int currentuser_id;
    private int warehouse_id;
    private String selected_date;
    private String batch_id;
    private String end_date;
    private String source;
}
