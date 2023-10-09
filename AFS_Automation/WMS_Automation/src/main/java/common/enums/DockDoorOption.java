package common.enums;

import lombok.Getter;

@Getter
public enum DockDoorOption {

    SELECT_DOOR("Select door"),
    D1("D1"),
    D2("D2"),
    DOOR("DOOR"),
    DOOR01("DR01"),
    DOOR02("DR02"),
    DOOR03("DR03"),
    DOOR04("DR04"),
    DOOR05("DR05"),
    DOOR06("DR06"),
    DOOR10("DR10"),
    GOLD("GOLD"),
    PRODUCTION("PRODUCTION"),
    TD01("TD01"),
    TD02("TD02");

    private final String dockDoorOption;

    DockDoorOption(String dockDoorOption){
        this.dockDoorOption = dockDoorOption;
    }
}
