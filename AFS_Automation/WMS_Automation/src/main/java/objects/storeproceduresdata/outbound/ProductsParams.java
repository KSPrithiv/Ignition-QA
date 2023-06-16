package objects.storeproceduresdata.outbound;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ProductsParams {
    private int active_only;
}
