package com.prasad.lld.parkinglot.model.vehicle;

import com.prasad.lld.parkinglot.enums.VehicleType;

public class Bike extends Vehicle {

    public Bike(String number){
        super(number,VehicleType.BIKE);
    }
}
