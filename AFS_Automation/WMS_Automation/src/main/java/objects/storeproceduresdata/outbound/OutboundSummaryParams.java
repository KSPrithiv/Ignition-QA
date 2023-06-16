package objects.storeproceduresdata.outbound;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class OutboundSummaryParams {
    private int warehouse_id;
    private int route_id;
    private String order_no;
    private String source;
    private String start_date;
    private String end_date;
    private int order_status_id;
    private int door_id;
    private int owner_id;
    private int carrier_id;
    private int order_type_id;
    private int currentuser_id;
    private String account_code;
    private String account_name;
    private String product_code;
}
