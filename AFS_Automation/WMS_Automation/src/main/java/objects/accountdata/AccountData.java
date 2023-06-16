package objects.accountdata;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AccountData {
    private String account;
    private String exclusiveOwner;
    private String description;
    private String city;
    private String state;
}
