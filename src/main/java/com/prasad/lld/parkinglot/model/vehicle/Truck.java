package com.prasad.lld.parkinglot.model.vehicle;

import com.prasad.lld.parkinglot.enums.VehicleType;

public class Truck extends Vehicle {

    public Truck(String number){
        super(number, VehicleType.TRUCK);
    }
}
