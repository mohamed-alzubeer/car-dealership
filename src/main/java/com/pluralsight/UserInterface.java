package com.pluralsight;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;


public class UserInterface {
    //Add scanner class to read the user from input
    private Scanner scanner =  new Scanner(System.in);
    Dealership dealership;

    public UserInterface() {

    }

    public void display(){
        init();

        boolean appRunning = true;
        while(appRunning){

            System.out.println("\n=== Car Dealership Menu ===");
            System.out.println("1 - Find vehicles by price");
            System.out.println("2 - Find vehicles by make/model");
            System.out.println("3 - Find vehicles by year range");
            System.out.println("4 - Find vehicles by color");
            System.out.println("5 - Find all vehicles by mileage");
            System.out.println("6 - Find vehicles by type");
            System.out.println("7 - List all vehicles");
            System.out.println("8 - Add a vehicle");
            System.out.println("9 - Remove a vehicle");
            System.out.println("10 - Sell/Lease a Vehicle");
            System.out.println("99 - Quit");
            System.out.print("Enter option: ");

            int choice = scanner.nextInt();
            switch (choice){

                case 1:
                    processGetByPriceRequest();
                    break;

                case 2:
                    processGetByMakeModelRequest();
                    break;
                case 3:
                    processGetByYearRequest();
                    break;
                case 4:
                    processGetByColorRequest();
                    break;
                case 5:
                    processGetByMileageRequest();
                    break;
                case 6:
                    processGetbyTypeRequest();
                    break;
                case 7:
                    processGetAllVehicleRequest();
                    break;
                case 8:
                    //add vehicle
                    processAddVehicleRequest();
                    break;
                case   9:
                    processRemoveVehicleRequest();
                    break;
                    //remove vehicel

                case 99:
                    appRunning = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Feature not yet implemented");
                    break;


            }


        }

    }

    public void processRemoveVehicleRequest() {

        System.out.println("Enter VIN of vehicle to remove: ");
        int vin = scanner.nextInt();
        Vehicle vehicleToRemove = null;
        for (Vehicle vehicle : dealership.getAllVehicles()) {
            if (vehicle.getVin() == vin) {
                vehicleToRemove = vehicle;
                break;
            }
        }

        if (vehicleToRemove != null) {
            dealership.removeVehicle(vehicleToRemove);
            System.out.println("Vehicle removed successfully");
        }else {
            System.out.println("Vehicle not found");
        }
    }

    public void processAddVehicleRequest() {
        System.out.print("Enter VIN: ");
        int vin= scanner.nextInt();

        System.out.print("Enter Year: ");
        int year = scanner.nextInt();

        System.out.print("Enter Make: ");
        String make = scanner.next();

        System.out.print("Enter Model: ");
        String model = scanner.next();

        System.out.println("Enter Type: ");
        String type = scanner.next();

        System.out.print("Enter Color: ");
        String color = scanner.next();

        System.out.println("Enter Odometer: ");
        int odometer = scanner.nextInt();

        System.out.println("enter price: ");
        BigDecimal price = scanner.nextBigDecimal();

        //create vehicle object
        Vehicle vehicle = new Vehicle(vin,year,make,model,type,color,odometer,price );
        //add to dealership inventory
        dealership.addVehicle(vehicle);
        System.out.println("Vehicle added successfully");
    }

    public void processGetByMileageRequest() {
        System.out.println("Please enter minimum mileage: ");
        int mileage = scanner.nextInt();

        System.out.println("Please enter maximum mileage: ");
        int mileage2 = scanner.nextInt();

        displayVehicles(dealership.getVehiclesByMileage(mileage, mileage2));
    }

    private void init(){

        //create a dealership file manager
        DealershipFileManager dealership = new DealershipFileManager();
        this.dealership = dealership.getDealership();

    }

    public void processGetByColorRequest(){


        //ask the user the color
        System.out.println("Enter color: ");
        String color = scanner.next();


        displayVehicles(dealership.getVehiclesByColor(color));

    }

    public void processGetbyTypeRequest(){
        System.out.println("Enter vehicle type: ");
        String vehicleType = scanner.next();
        displayVehicles(dealership.getVehiclesByType(vehicleType));
    }

    public void processGetByMakeModelRequest(){
        System.out.println("Enter make make: ");
        String makeModel = scanner.next();

        System.out.println("Enter make model: ");
        String model = scanner.next();

        displayVehicles(dealership.getVehiclesByMakeModel(makeModel, model));


    }

    public void processGetByYearRequest(){
        System.out.println("Enter minimum year : ");
        int year = scanner.nextInt();

        System.out.println("Enter maximum year : ");
        int year2 = scanner.nextInt();
        displayVehicles(dealership.getVehiclesByYear(year, year2));



    }

    public void processGetByPriceRequest(){
        System.out.println("Enter minimum price : ");
        BigDecimal min = scanner.nextBigDecimal();

        System.out.println("Enter maximum price : ");
        BigDecimal max = scanner.nextBigDecimal();

        displayVehicles(dealership.getVehiclesByPrice(min, max));


    }
    public void processGetAllVehicleRequest(){

        displayVehicles(dealership.getAllVehicles());

    }

    private void displayVehicles(ArrayList<Vehicle> vehicles){

        //looper over the list and print it to the screen
        for(Vehicle vehicle : vehicles){
            //make this better, tables and such
            System.out.println(vehicle.toString());
        }

    }

}
