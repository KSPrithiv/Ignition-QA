package common.enums;

import lombok.Getter;

@Getter
public enum RouteType {

    OUTBOUND("Outbound"),
    OUTBOUND_WILLCALL("Outbound WillCall"),
    TESTSAV("TESTSAV");

    private final String routeType;

    RouteType(String routeType) {
        this.routeType = routeType;
    }
}
