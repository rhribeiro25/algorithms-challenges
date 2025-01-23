package br.com.rhribeiro25;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private int capacity;
    private Map<Integer, String> parkedCars;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        this.parkedCars = new HashMap<>();
    }

    public boolean parkCar(int slot, String carPlate) {
        if (slot > capacity || parkedCars.containsKey(slot)) {
            return false; // Slot unavailable
        }
        parkedCars.put(slot, carPlate);
        return true;
    }

    public boolean leaveCar(int slot) {
        return parkedCars.remove(slot) != null;
    }

    public void displayStatus() {
        System.out.println("Parking Lot Status:");
        for (int slot : parkedCars.keySet()) {
            System.out.println("Slot " + slot + ": " + parkedCars.get(slot));
        }
    }

    public static void main(String[] args) {
        ParkingLot lot = new ParkingLot(5);

        lot.parkCar(1, "ABC123");
        lot.parkCar(3, "XYZ789");
        lot.displayStatus();

        lot.leaveCar(1);
        lot.displayStatus();
    }
}
