package com.example.entity;

import java.text.DecimalFormat;

public class Vehicle {

    private  double fuelCapacity ;

    private double fuelAvailable ; // in liter

    private static double consumption = 0.056; // 5.6 liter per 100km  5.6/100    0.056/1

    private double travelConsumption;

    private static double fuelPrice = 15.23;

    private Boolean isDrivable = true;

    DecimalFormat df = new DecimalFormat("0.00");

    public Vehicle() {
    }

    public Vehicle(double fuelAvailable, double travelConsumption, double fuelCapacity) {
        this.fuelAvailable = fuelAvailable;
        this.travelConsumption = travelConsumption;
        this.fuelCapacity = fuelCapacity;

    }



    public double kmCanTravel(){
       double result = fuelAvailable / consumption; // 60 / 0.056 = 1071.42
        return Double.parseDouble(df.format(result));

    }

    public void drive(double km){
        if(km > 0 && km <= kmCanTravel()){
            // average car petrol consumption  5.6 liter/100 km   0.056 liter /1 km      0.056/1 * km;
            System.out.println("\nFuel Gauge: " + df.format(fuelAvailable) + " liters");

            travelConsumption = consumption / 1 * km;

            System.out.println("Drove " + km + " km");
            fuelAvailable = fuelAvailable - travelConsumption;

            DecimalFormat df = new DecimalFormat("0.00");
            System.out.println("Fuel used: " + df.format(travelConsumption) + " liters");
            System.out.println("Fuel Gauge: " + df.format(fuelAvailable)+" liters");
            System.out.println("Km Remaining per fuel: " + kmCanTravel());
            System.out.println("is drivable: " + isDrivable);
        }else if (km > kmCanTravel()){
            //

            double remainingKmToDrive = km - kmCanTravel();
            System.out.println("\nFuel Gauge: " + fuelAvailable + " liters");

            travelConsumption = consumption / 1 * kmCanTravel();
            System.out.println("Drove " + kmCanTravel());

            fuelAvailable -= travelConsumption;

            System.out.println( "Out of fuel!!" + "\nFuel used: " + df.format(travelConsumption) + " liters");
            System.out.println("Km Remaining: " + kmCanTravel()+"km" );
            System.out.println("Kilometer remaining to destination: " + df.format(remainingKmToDrive));

            isDrivable = false;
            System.out.println("is drivable: " + false);

            System.out.println("\nTo continue driving fill up...");
        }
    }


    public void fillUpFuel(double amount){
        // R15.23 per liter    1 liter / 15.23 * 300

        if((amount >= fuelPrice) && (amount <= 60 * fuelPrice)){
            System.out.println("filling up...");
            fuelAvailable = 1 / fuelPrice * amount; //convert amount to liter

            isDrivable = true;
            System.out.println("Fuel Gauge: " + df.format(fuelAvailable) + "\nis drivable: " + isDrivable);
        }else if(amount < fuelPrice) {
            System.out.println("Amount must be more than R" + fuelPrice);
        }

       /* if(fuelCapacity < fuelCapacity + travelConsumption && (amount > fuelPrice && (amount <= fuelCapacity * fuelPrice)) ){
            double literFilled = 1 / fuelPrice * amount;
            System.out.println("filling up...");
        }else if(fuelCapacity - travelConsumption == fuelCapacity ){
            System.out.println("Fuel is full");
        }else if(amount > fuelCapacity){} //if amount is over the fuel liters*/


        System.out.println("Km Remaining: " + kmCanTravel()+"km" );

    }


    public double getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(double fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    public double getFuelAvailable() {
        return fuelAvailable;
    }

    public void setFuelAvailable(double fuelAvailable) {
        this.fuelAvailable = fuelAvailable;
    }

    public double getConsumption() {
        return consumption;
    }

    public double getTravelConsumption() {
        return travelConsumption;
    }

    public void setTravelConsumption(double travelConsumption) {
        this.travelConsumption = travelConsumption;
    }

    public static double getFuelPrice() {
        return fuelPrice;
    }

    public static void setFuelPrice(double fuelPrice) {
        Vehicle.fuelPrice = fuelPrice;
    }
    public Boolean getDrivable() {
        return isDrivable;
    }

    public void setDrivable(Boolean drivable) {
        isDrivable = drivable;
    }
}
