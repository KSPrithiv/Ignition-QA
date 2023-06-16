package objects.storeproceduresdata.appointment;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentParams {
    private String user_name;
    private String search_string;
    private int webuser_warehouse;
    private int currentuser_id;
}
