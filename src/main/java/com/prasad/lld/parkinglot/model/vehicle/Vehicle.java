package com.prasad.lld.parkinglot.model.vehicle;

import com.prasad.lld.parkinglot.enums.VehicleType;

public class Vehicle {
    protected String number;
    protected VehicleType vehicleType;


    public Vehicle(String number,VehicleType vehicleType){
        this.number=number;
        this.vehicleType=vehicleType;
    }

    public String getNumber(){
        return number;
    }

    public VehicleType getVehicleType(){
        return vehicleType;
    }
}
