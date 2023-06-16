package common.enums;

import lombok.Getter;

@Getter
public enum BatchType {
    DEFAULT("(Select batch type)"),
    PD_PICKS("PD PICKS");

    private final String batchType;

    BatchType(String batchType){
        this.batchType = batchType;
    }
}
