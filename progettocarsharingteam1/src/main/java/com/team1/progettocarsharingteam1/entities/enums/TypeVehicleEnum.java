package com.team1.progettocarsharingteam1.entities.enums;

public enum TypeVehicleEnum {
    CAR("Car"),
    MOTORCYCLE("Motorcycle"),
    HOVERBOARD("Hoverboard"),
    BICYCLE("Bicycle");
    private final String typeVehicle;

    TypeVehicleEnum(String typeVehicle) {
        this.typeVehicle = typeVehicle;
    }

    public String getDesciption() {
        return typeVehicle;
    }
}
