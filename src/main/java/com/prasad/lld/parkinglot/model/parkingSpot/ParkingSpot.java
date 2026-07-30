package com.prasad.lld.parkinglot.model.parkingSpot;

import com.prasad.lld.parkinglot.enums.SpotType;
import com.prasad.lld.parkinglot.model.vehicle.Vehicle;

public abstract class ParkingSpot {

    protected Long id;
    protected SpotType spotType;
    protected boolean isOccupied;
    protected Vehicle vehicle;


    public ParkingSpot(SpotType spotType, boolean isOccupied, Vehicle vehicle){
        this.spotType=spotType;
        this.isOccupied=isOccupied;
        this.vehicle=vehicle;
    }

    public boolean isAvailable(){
        return !isOccupied;
    }

    public void parkVehicle(Vehicle vehicle){
        if (this.isOccupied){
            throw new RuntimeException("spot is occupied");
        }
        this.vehicle=vehicle;
        this.isOccupied=true;
    }

    public void removeVehicle(){
        if (!this.isOccupied){
            throw new RuntimeException("Spot is already free");
        }
        this.vehicle=null;
        this.isOccupied=false;
    }
}
