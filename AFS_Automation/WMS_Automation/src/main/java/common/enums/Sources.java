package common.enums;

import lombok.Getter;

@Getter
public enum Sources {
    DEFAULT("(Default)"),
    ACCOUNT("Account"),
    SUPPLIER("Supplier"),
    WAREHOUSE("Warehouse");

    private final String source;

    Sources(String source){
        this.source = source;
    }
}
