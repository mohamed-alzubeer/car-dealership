package com.pluralsight;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Dealership {

    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> inventory;

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;

        //create the dealership with no inventory
        this.inventory = new ArrayList<>();
    }

    //add vehicles to the inventory
    public void addVehicle(Vehicle vehicle) {
        this.inventory.add(vehicle);
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;


    }


    //get all vehicles
    public ArrayList<Vehicle> getAllVehicles() {
        return this.inventory;


    }
    public void removeVehicle(Vehicle vehicle) {
        //take the vehicle passed in out of the inventory list
        this.inventory.remove(vehicle);
    }

    public ArrayList<Vehicle> getVehiclesByPrice(BigDecimal min, BigDecimal max) {
        ArrayList<Vehicle> filteredVehicles = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getPrice().compareTo(min) >= 0 && vehicle.getPrice().compareTo(max) <= 0) {
                filteredVehicles.add(vehicle);
            }
        }
return filteredVehicles;
        //loop over inventory and return a list of vehicles that match the price range

        //start a new list for the filtered cars

        //loop over inventory and add matching cards to filtered list

        //return the list

    }

    public ArrayList<Vehicle> getVehiclesByMakeModel(String make, String model) {
        //loop over inventory and return a list of vehicles that match the make and model
        //start a new list for the filtered cars
        //loop over inventory and add matching cards to filtered list
        //return the list
        // list to hold matching vehicles
        ArrayList<Vehicle> filteredVehicles = new ArrayList<>();
        //check every vehcle in inventory
        for (Vehicle vehicle : this.inventory) {
            //check if both make and model match
            if (vehicle.getMake().equals(make) && vehicle.getModel().equals(model)) {
                filteredVehicles.add(vehicle);
            }
        }

        return  filteredVehicles;
    }

    public ArrayList<Vehicle> getVehiclesByYear(int min, int Max) {

        //loop over inventory and return a list of vehicles that match the year range

        //start a new list for the filtered cars

        //loop over inventory and add matching cards to filtered list

        //return the list

        //list all vehicle
        ArrayList<Vehicle> filteredVehicles = new ArrayList<>();
        //check every vehicle
        for (Vehicle vehicle : inventory) {
            //check if year is between min and max
            if (vehicle.getYear() >= min && vehicle.getYear() <= Max) {
                filteredVehicles.add(vehicle);
            }
        }

        return   filteredVehicles;
    }

    public ArrayList<Vehicle> getVehiclesByColor(String color) {
//create a list
        ArrayList<Vehicle> filteredVehicles = new ArrayList<>();
        //loot throught inventory
        for (Vehicle vehicle : this.inventory) {
            //check if vehicle color matches or not
            if (vehicle.getColor().equalsIgnoreCase(color)) {
                //if the color matches add the vehicle to the filtered list
                filteredVehicles.add(vehicle);
            }
        }
        //return all matches vehicles
        return filteredVehicles;
    }

    public ArrayList<Vehicle> getVehiclesByMileage(int min, int max) {

        //loop over inventory and return a list of vehicles that match the min and max mileage
        //start a new list for the filtered cars
        //loop over inventory and add matching cards to filtered list
        //return the list

        ArrayList<Vehicle> filteredVehicles = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getOdometer() >= min && vehicle.getOdometer() <= max) {
                filteredVehicles.add(vehicle);
            }
        }

        return   filteredVehicles;
    }

    public ArrayList<Vehicle> getVehiclesByType(String type) {

        //loop over inventory and return a list of vehicles that match the type
        //start a new list for the filtered cars
        //loop over inventory and add matching cards to filtered list
        //return the list

        //crate list for matching vehicles
        ArrayList<Vehicle> filteredVehicles = new ArrayList<>();
        //check every vehicle
        for (Vehicle vehicle : inventory) {
            // I want to compare  vehicle type with user type
            if(vehicle.getVehicleType().equalsIgnoreCase(type)) {
                //add matching vehicle
                filteredVehicles.add(vehicle);

            }
        }

        //give back the matching vehicles
        return filteredVehicles;

    }

}


