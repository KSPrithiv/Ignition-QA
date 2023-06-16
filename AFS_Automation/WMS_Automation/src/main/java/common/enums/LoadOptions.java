package common.enums;

import lombok.Getter;

@Getter
public enum LoadOptions {

    EDIT("Edit"),
    RECEIVE("Receive"),
    SOURCE("Source"),
    REVIEW("Review");

    private final String loadOption;

    LoadOptions(String loadOption){ this.loadOption = loadOption; }
}
