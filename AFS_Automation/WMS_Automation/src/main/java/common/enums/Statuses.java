package common.enums;

import lombok.Getter;

@Getter
public enum Statuses {
    CANCELLED("Cancelled"),
    OPEN("Open"),
    CLOSED("Closed"),
    SHIPMENT_IN_PROGRESS("Shipment in Progress"),
    READY_TO_RECEIVE("Ready To Receive"),
    ALL_STATUSES("All statuses"),
    RECEIVED_ORDER("Received Order");

    private final String status;

    Statuses(String status) {
        this.status = status;
    }

}
