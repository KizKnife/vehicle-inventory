package com.pluralsight;

import java.util.Objects;
import java.util.Scanner;

public class VehicleInventory {
    public static void main(String[] args) {
        Vehicle[] vehicles = new Vehicle[20];

        preloadVehicles(vehicles);

        menuNavigation(vehicles);
    }

    public static void preloadVehicles(Vehicle[] vehicles) {
        vehicles[0] = new Vehicle(
                101121,
                "Ford Explorer",
                "Red",
                45000,
                13500
        );

        vehicles[1] = new Vehicle(
                101122,
                "Toyota Camry",
                "Blue",
                45000,
                13500
        );

        vehicles[2] = new Vehicle(
                101123,
                "Chevrolet Malibu",
                "Black",
                45000,
                9700
        );

        vehicles[3] = new Vehicle(
                101124,
                "Honda Civic",
                "White",
                70000,
                7500
        );

        vehicles[4] = new Vehicle(
                101125,
                "Subaru Outback",
                "Green",
                55000,
                14500
        );

        vehicles[5] = new Vehicle(
                101126,
                "Jeep Wrangler",
                "Yellow",
                30000,
                16000
        );
    }

    public static void menuNavigation(Vehicle[] vehicles) {
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("What do you want to do?");
            System.out.println(" 1 - List all vehicles");
            System.out.println(" 2 - Search by make/model");
            System.out.println(" 3 - Search by price range");
            System.out.println(" 4 - Search by color");
            System.out.println(" 5 - Add a vehicle");
            System.out.println(" 6 - Quit");
            System.out.print("Enter your command: ");

            switch(input.nextLine()) {
                case "1":
                    listAllVehicles(vehicles);
                    break;
                case "2":
                    findVehicleByMakeModel(vehicles);
                    break;
                case "3":
                    findVehicleByPrice(vehicles);
                    break;
                case "4":
                    findVehicleByColor(vehicles);
                    break;
                case "5":
                    addAVehicle(vehicles);
                    break;
                case "6":
                    System.out.println("Thank you! Goodbye!");
                    return;
            }
        }
    }

    public static void listAllVehicles(Vehicle[] vehicles) {
        for (int i = 0; i < vehicles.length; i++) {
            if (vehicles[i] != null) {
                System.out.printf("%d, %s, %s, %dkm, $%.0f%n",
                        vehicles[i].getVehicleId(),
                        vehicles[i].getMakeModel(),
                        vehicles[i].getColor(),
                        vehicles[i].getOdometerReading(),
                        vehicles[i].getPrice()
                        );
            }
        }
        System.out.println();
    }

    public static void findVehicleByMakeModel(Vehicle[] vehicles) {
        Scanner input = new Scanner(System.in);
        String makeModel;
        System.out.print("Enter make/model: ");
        makeModel = input.nextLine();

        for (int i = 0; i < vehicles.length; i++) {
            if (vehicles[i] != null) {
                if (Objects.equals(vehicles[i].getMakeModel(), makeModel)) {
                    System.out.printf("%d, %s, %s, %d, %.0f%n",
                            vehicles[i].getVehicleId(),
                            vehicles[i].getMakeModel(),
                            vehicles[i].getColor(),
                            vehicles[i].getOdometerReading(),
                            vehicles[i].getPrice()
                    );
                }
            }
        }

        System.out.println();
    }

    public static void findVehicleByPrice(Vehicle[] vehicles) {
        Scanner input = new Scanner(System.in);
        int minPriceRange;
        int maxPriceRange;
        System.out.print("Enter min price range: $");
        minPriceRange = input.nextInt();
        System.out.print("Enter max price range: $");
        maxPriceRange = input.nextInt();

        for (int i = 0; i < vehicles.length; i++) {
            if (vehicles[i] != null) {
                if (vehicles[i].getPrice() > minPriceRange && vehicles[i].getPrice() < maxPriceRange) {
                    System.out.printf("%d, %s, %s, %d, %.0f%n",
                            vehicles[i].getVehicleId(),
                            vehicles[i].getMakeModel(),
                            vehicles[i].getColor(),
                            vehicles[i].getOdometerReading(),
                            vehicles[i].getPrice()
                    );
                }
            }
        }

        System.out.println();
    }

    public static void findVehicleByColor(Vehicle[] vehicles) {
        Scanner input = new Scanner(System.in);
        String color;
        System.out.print("Enter color: ");
        color = input.nextLine();

        for (int i = 0; i < vehicles.length; i++) {
            if (vehicles[i] != null) {
                if (Objects.equals(vehicles[i].getColor(), color)) {
                    System.out.printf("%d, %s, %s, %d, %.0f%n",
                            vehicles[i].getVehicleId(),
                            vehicles[i].getMakeModel(),
                            vehicles[i].getColor(),
                            vehicles[i].getOdometerReading(),
                            vehicles[i].getPrice()
                    );
                }
            }
        }

        System.out.println();
    }

    public static void addAVehicle(Vehicle[] vehicle) {
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < vehicle.length; i ++) {
            if (vehicle[i] == null) {
                System.out.printf("Lot: #%d is open!%n", i);

                System.out.print("Enter vehicle ID: ");
                int vehicleId = input.nextInt();
                input.nextLine();

                System.out.print("Enter make/model: ");
                String makeModel = input.nextLine();

                System.out.print("Enter color: ");
                String color = input.nextLine();

                System.out.print("Enter vehicle odometer reading: ");
                int odometerReading = input.nextInt();

                System.out.print("Enter vehicle price: ");
                float price = input.nextFloat();

                vehicle[i] = new Vehicle(vehicleId, makeModel,color, odometerReading, price);

                System.out.printf("Vehicle %d added at slot #%d", i, i);

                break;
            }
        }
    }

}