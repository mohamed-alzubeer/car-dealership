package com.pluralsight;

import java.io.*;
import java.math.BigDecimal;

public class DealershipFileManager {

    // Name of the inventory file
    private String csvFile = "inventory.csv";


    // METHOD 1: Read dealership information from the file
    public Dealership getDealership() {

        Dealership dealership = null;

        // Try-with-resources automatically closes the reader
        try (BufferedReader inventoryReader =
                     new BufferedReader(new FileReader(csvFile))) {

            // Read the first line (dealership information)
            String dealershipInfo = inventoryReader.readLine();

            // Check if dealership information exists
            if (dealershipInfo != null) {

                String[] dealerShipParts = dealershipInfo.split("\\|");

                String name = dealerShipParts[0];
                String address = dealerShipParts[1];
                String phone = dealerShipParts[2];

                // Create the dealership object
                dealership = new Dealership(name, address, phone);
            }

            // Read the remaining lines (vehicles)
            String vehicleLine;

            while ((vehicleLine = inventoryReader.readLine()) != null) {

                String[] vehicleParts = vehicleLine.split("\\|");

                int vin = Integer.parseInt(vehicleParts[0]);
                int year = Integer.parseInt(vehicleParts[1]);
                String make = vehicleParts[2];
                String model = vehicleParts[3];
                String type = vehicleParts[4];
                String color = vehicleParts[5];
                int odometer = Integer.parseInt(vehicleParts[6]);

                BigDecimal price = new BigDecimal(vehicleParts[7]);

                // Create a new Vehicle object
                Vehicle newCar = new Vehicle(
                        vin,
                        year,
                        make,
                        model,
                        type,
                        color,
                        odometer,
                        price
                );

                // Add vehicle to dealership
                dealership.addVehicle(newCar);
            }

        } catch (Exception e) {

            System.out.println("Error reading the file: " + e.getMessage());
        }

        // Return the dealership object
        return dealership;
    }


    // METHOD 2: Save dealership information to the file
    public void saveDealership(Dealership dealership) throws IOException {

        // Create a writer to write information into the file
        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter(csvFile))) {

            // Write dealership information
            writer.write(
                    dealership.getName() + "|" +
                            dealership.getAddress() + "|" +
                            dealership.getPhone()
            );

            writer.newLine();

            // Write all vehicles
            for (Vehicle vehicle : dealership.getAllVehicles()) {

                writer.write(vehicle.toString());

                writer.newLine();
            }

        }
    }
}