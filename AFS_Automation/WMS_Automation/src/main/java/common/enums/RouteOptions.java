package common.enums;

import lombok.Getter;

@Getter
public enum RouteOptions {

    EDIT("Edit"),
    RELEASE("Release"),
    DOOR("Door"),
    SOURCE("Source"),
    DATA("Data"),
    REVIEW("Review");

    private final String routeOption;

    RouteOptions(String routeOption) {
        this.routeOption = routeOption;
    }
}
