package objects.userdata;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DataBaseData {
    private String username;
    private String password;
    private String host;
    private String port;
    private String schema;
}
