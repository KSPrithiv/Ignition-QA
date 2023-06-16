package common.enums;

import lombok.Getter;

@Getter
public enum TaskGroupOption {
    CYCLE_COUNT("Cycle Count"),
    DEE("DEE"),
    DEFAULT_TASK_GROUP("Default task group"),
    LOADING("Loading"),
    REPLENISH_NEEDING_LOCATION("Replenish needing location"),
    PICK_CHILL_PALLETS("Pick Chill Pallets"),
    PICK_DRY_PALLETS("Pick Dry Pallets"),
    PICK_FREEZER_PALLETS("Pick Freezer Pallets"),
    PICK_FROM_CHILL_WP("Pick from Chill WP"),
    PICK_FREEZER("Pick Freezer"),
    PUTAWAY("Putaway"),
    REPLENISHMENTS("Replenishments"),
    SHIPPING("Shipping");

    private final String taskGroup;

    TaskGroupOption(String taskGroup) {
        this.taskGroup = taskGroup;
    }

}
