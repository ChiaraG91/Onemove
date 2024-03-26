package com.team1.progettocarsharingteam1.entities.enums;

public enum ChargeEnum {

    SHORT ("short charge"),
    MEDIUM ("medium charge "),
    LONG ("long charge");

    private final String chargeEnum;

    ChargeEnum(String chargeEnum) {
        this.chargeEnum = chargeEnum;
    }

    public String getChargeEnum() {
        return chargeEnum;
    }
}
