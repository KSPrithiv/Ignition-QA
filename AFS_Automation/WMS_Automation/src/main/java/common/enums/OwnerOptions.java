package common.enums;

import lombok.Getter;

@Getter
public enum OwnerOptions {

    SELECT_OWNER("Select owner"),
    RHEE_BROS("RHEE BROS., INC."),
    TEST_OWNER("Test Owner");

    private final String ownerOption;

    OwnerOptions(String ownerOption){
        this.ownerOption = ownerOption;
    }
}
