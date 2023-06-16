package objects.userdata;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserData {
    private String username;
    private String password;
    private String adminUsername;
    private String adminPassword;
}
