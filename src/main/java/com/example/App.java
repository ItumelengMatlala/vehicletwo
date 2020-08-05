package com.example;

import com.example.entity.Car;

import java.text.DecimalFormat;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {


        Scanner scan = new Scanner(System.in);
        Car car = new Car();

        System.out.println("Build your own car");

        System.out.print("Car Make: ");
        car.setMake(scan.nextLine());

        System.out.print("Car Model: ");
        car.setModel(scan.nextLine());


        System.out.print("Fuel capacity liters e.g. 50: ");
        double a = scan.nextDouble();
        car.setFuelCapacity(a);
        car.setFuelAvailable(a);

        System.out.println("\n" + car.getMake() + ", " +car.getModel() + ", " + "Fuel Capacity " + car.getFuelAvailable() + " liters");

        DecimalFormat df = new DecimalFormat("0.00");
        double consumption = car.getConsumption() * 100;

        System.out.println("Fuel Consumption: " + df.format(consumption) + "l / 100km");
        System.out.println("Km Remaining: " + car.kmCanTravel());

        // drive loop
        while (car.getDrivable()){
            System.out.print("\nHow many kilometers do you want to drive: " );
            car.drive(scan.nextDouble());

            //fill up fuel loop
            while(car.getFuelAvailable() < 0){
                System.out.print("\nEnter refill amount e.g.100: " );
                car.fillUpFuel(scan.nextDouble());
            }
        }


    }

}



