package objects.productdata;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ProductData {
    private String productCode;
    private String productDescription;
    private String productAmount;
}
