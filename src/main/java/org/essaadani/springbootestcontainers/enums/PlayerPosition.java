package org.essaadani.springbootestcontainers.enums;

public enum PlayerPosition {
    // Goalkeeper
    GK("Goalkeeper"),

    // Defenders
    CB("Center Back"),
    LB("Left Back"),
    RB("Right Back"),
    LWB("Left Wing Back"),
    RWB("Right Wing Back"),

    // Midfielders
    CDM("Central Defensive Midfielder"),
    CM("Central Midfielder"),
    CAM("Central Attacking Midfielder"),
    LM("Left Midfielder"),
    RM("Right Midfielder"),
    LW("Left Winger"),
    RW("Right Winger"),

    // Forwards
    CF("Center Forward"),
    ST("Striker"),
    LF("Left Forward"),
    RF("Right Forward"),

    // Additional Midfield Positions
    LDM("Left Defensive Midfielder"),
    RDM("Right Defensive Midfielder"),
    LCM("Left Central Midfielder"),
    RCM("Right Central Midfielder"),
    LAM("Left Attacking Midfielder"),
    RAM("Right Attacking Midfielder"),

    // Additional Forward Positions
    LS("Left Striker"),
    RS("Right Striker");

    private final String position;

    PlayerPosition(String position) {
        this.position = position;
    }

    public String getPosition() {
        return position;
    }
}
