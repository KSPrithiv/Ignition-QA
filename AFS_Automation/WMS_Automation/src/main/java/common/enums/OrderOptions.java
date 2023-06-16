package common.enums;

import lombok.Getter;

@Getter
public enum OrderOptions {

    EDIT("Edit"),
    RECEIVE("Receive"),
    RELEASE("Release"),
    DOOR("Door"),
    SOURCE("Source"),
    DATA("Data"),
    LOG("Log"),
    MOVE("Move"),
    IMAGE("Image"),
    REVIEW("Review");

    private final String orderOption;

    OrderOptions(String orderOption) {
        this.orderOption = orderOption;
    }
}
