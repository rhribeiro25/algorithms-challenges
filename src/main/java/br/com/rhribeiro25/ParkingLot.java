package br.com.rhribeiro25;

public class ParkingLot {

    private Integer[] parkingSpaces; // Array representing parking spots (null means empty)
    private int capacity; // Total number of parking spots

    // Constructor to initialize the parking lot with a given capacity
    public ParkingLot(int capacity) {
        this.capacity = capacity;
        this.parkingSpaces = new Integer[capacity]; // Initialize parking lot with null values (empty spots)
    }

    // Parks a car with the given carId in the first available space
    public boolean park(int carId) {
        for (int i = 0; i < parkingSpaces.length; i++) {
            if (parkingSpaces[i] == null) {
                parkingSpaces[i] = carId; // Park the car
                return true; // Successfully parked
            }
        }
        return false; // No available spaces
    }

    // Removes the car with the given carId from the parking lot
    public boolean leave(int carId) {
        for (int i = 0; i < parkingSpaces.length; i++) {
            if (parkingSpaces[i] != null && parkingSpaces[i] == carId) {
                parkingSpaces[i] = null; // Free the parking space
                return true; // Successfully removed the car
            }
        }
        return false; // Car not found
    }

    // Returns the number of available parking spaces
    public int getAvailableSpaces() {
        int count = 0;
        for (Integer space : parkingSpaces) {
            if (space == null) {
                count++;
            }
        }
        return count;
    }

    // Checks if the parking lot is full
    public boolean isFull() {
        return getAvailableSpaces() == 0;
    }

    // Checks if the parking lot is empty
    public boolean isEmpty() {
        return getAvailableSpaces() == capacity;
    }

    // Main method to test the parking lot functionality
    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot(3); // Parking lot with 3 spaces

        // Test parking cars
        System.out.println(parkingLot.park(1)); // Returns true (Car 1 parked)
        System.out.println(parkingLot.park(2)); // Returns true (Car 2 parked)
        System.out.println(parkingLot.getAvailableSpaces()); // Returns 1 (1 spot available)
        System.out.println(parkingLot.park(3)); // Returns true (Car 3 parked)
        System.out.println(parkingLot.isFull()); // Returns true (Parking lot is full)

        // Test leaving cars
        System.out.println(parkingLot.leave(1)); // Returns true (Car 1 left)
        System.out.println(parkingLot.getAvailableSpaces()); // Returns 2 (2 spots available)
        System.out.println(parkingLot.isFull()); // Returns false (Parking lot is not full)
        System.out.println(parkingLot.isEmpty()); // Returns false (Parking lot is not empty)
    }
}

/*
 * Problem: Parking Lot
 *
 * **Objective**:
 * The task is to design and implement a parking lot system with a limited number of parking spots that allows cars to park and leave.
 * The system should support the following operations:
 * - `park(carId)`: Parks a car in the first available space.
 * - `leave(carId)`: Removes the car with the given `carId` from the parking lot.
 * - `getAvailableSpaces()`: Returns the number of available parking spaces.
 * - `isFull()`: Checks if the parking lot is full.
 * - `isEmpty()`: Checks if the parking lot is empty.
 *
 * **Problem Definition**:
 * You need to create a system that simulates a parking lot with a fixed number of parking spots. Each parking spot can hold only one car at a time.
 * The system should ensure that cars can park and leave, and it should provide information about the available parking spaces.
 *
 * **Approach**:
 * - We can model the parking lot using an array or list to represent the parking spots.
 * - Each element in the list corresponds to a parking spot, which can either be empty (null or 0) or occupied by a car (a unique `carId`).
 * - The parking lot will have a fixed capacity, and we need to track the current number of parked cars.
 * - When a car parks, we assign it to the first available spot. When a car leaves, we free up the spot occupied by that car.
 *
 * **Space Complexity**:
 * - The space complexity is **O(n)**, where `n` is the number of parking spots in the parking lot.
 *   We need an array or list of size `n` to represent the parking lot.
 *
 * **Time Complexity**:
 * - The time complexity for parking and leaving cars is **O(n)** in the worst case, because we may need to iterate through the parking lot to find the first available or occupied spot.
 *   However, other operations like `getAvailableSpaces`, `isFull`, and `isEmpty` can be done in constant time **O(1)**.
 *
 * **Example**:
 * Let's consider a parking lot with 3 spots:
 * parkingLot = new ParkingLot(3);
 * parkingLot.park(1); // Parks car with ID 1 in the first spot.
 * parkingLot.park(2); // Parks car with ID 2 in the second spot.
 * parkingLot.getAvailableSpaces(); // Returns 1.
 * parkingLot.leave(1); // Car with ID 1 leaves the parking lot.
 * parkingLot.getAvailableSpaces(); // Returns 2.
 */

