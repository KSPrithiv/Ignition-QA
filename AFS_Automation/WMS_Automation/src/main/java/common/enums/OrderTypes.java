package common.enums;

import lombok.Getter;

@Getter
public enum OrderTypes {

    SHIPPER("Shipper"),
    RETAIL("Retail"),
    WHOLESALE_GOLD("Wholesale Gold"),
    RETAIL_GOLD("Retail Gold"),
    EMPLOYEE_SALES("Employee Sales"),
    OUTBOUND_TRANSFER("Outbound Transfer"),
    REGULAR_ORDERS("REGULAR ORDERS"),
    CUSTOMER_ORDER("Customer Order"),
    VENDOR_RETURN("Vendor Return");

    private final String orderType;

    OrderTypes(String orderType) {
        this.orderType = orderType;
    }
}
