package objects.storeproceduresdata.inbound;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class InboundLoadsSummaryParams {
    private int warehouse_id;
    private String route_code;
    private int isActive;
    private String start_date;
    private String end_date;
    private int order_status_id;
    private int door_id;
    private int owner_id;
    private int carrier_id;
    private int route_type_id;
    private int currentuser_id;
    private String vendor_code;
    private String vendor_name;
    private String product_code;
}
