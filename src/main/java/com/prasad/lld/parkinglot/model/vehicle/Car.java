package com.prasad.lld.parkinglot.model.vehicle;

import com.prasad.lld.parkinglot.enums.VehicleType;

public class Car extends Vehicle {

    public Car(String number) {
        super(number, VehicleType.CAR);
    }
}
