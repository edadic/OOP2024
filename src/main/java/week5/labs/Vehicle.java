package week5.labs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Vehicle {

    private String modelName;
    private int mileage;
    private int health;

    public Vehicle(String modelName) {
        this.modelName = modelName;
        this.mileage = 0;
        this.health = 100;
    }

    public Vehicle(String modelName, int mileage, int health) {
        this.modelName = modelName;
        this.mileage = mileage;
        this.health = health;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getModelName() {
        return modelName;
    }

    public int getMileage() {
        return mileage;
    }

    public int getHealth() {
        return health;
    }

    public abstract String service();

    public abstract int expectedLifespan();

    public boolean needsMaintenance() {
        return health < 70;
    }

    public int calculateRemainingLifespan() {
        int expectedLifespan = expectedLifespan();
        int adjustedLifespan = expectedLifespan;

        if (health < 50) {
            adjustedLifespan = expectedLifespan * health / 100;
        }
        return adjustedLifespan - mileage;
    }

    public void simulateYear() {
        if(mileage > expectedLifespan() / 2) {
            health -= 5;
        } else {
            health = health - mileage / expectedLifespan();
        }
    }

    public void performMaintenance(Vehicle vehicle) {
        if(vehicle instanceof Car) {
            Car car = (Car) vehicle;
            car.repair();
            car.drive(1000);
        } else if (vehicle instanceof Truck) {
            Truck truck = (Truck) vehicle;
            truck.repair();
            truck.haul(5000);
        } else if (vehicle instanceof Motorcycle) {
            Motorcycle motorcycle = (Motorcycle) vehicle;
            motorcycle.race(300);
        }
    }

    @Override
    public String toString() {
        return
                "Model name: " + modelName +
                " Mileage=" + mileage +
                " Health=" + health;
    }
}

interface Repairable {
    String repair();
}

class Car extends Vehicle implements Repairable {

    public Car(String modelName) {
        super(modelName);
    }

    public Car(String modelName, int mileage, int health) {
        super(modelName, mileage, health);
    }

    @Override
    public String repair() {
        return "Engine tuned and oil changed for" + getModelName();
    }

    @Override
    public String service() {
        return "Checking engine for " + getModelName() + "\nMileage: " + getMileage() + "\nHealth: " + getHealth();
    }

    @Override
    public int expectedLifespan() {
        return 150000;
    }

    public void drive(int miles) {
        setMileage(getMileage() + miles);
        setHealth(getHealth() - miles / 1000);

        if(getHealth()<30) {
            setMileage(getMileage() + 10000);
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

class Truck extends Vehicle implements Repairable {

    public Truck(String modelName) {
        super(modelName);
    }

    public Truck(String modelName, int mileage, int health) {
        super(modelName, mileage, health);
    }

    @Override
    public String repair() {
        return "Engine overhauled and tires replaced for " + getModelName();
    }

    @Override
    public String service() {
        return "Checking engine for " + getModelName() + "\nMileage: " + getMileage() + "\nHealth: " + getHealth();
    }

    @Override
    public int expectedLifespan() {
        return 300000;
    }

    public void haul(int loadWeight) {
        if(loadWeight > 5000) {
            setHealth(getHealth() - loadWeight/500);
        } else {
            setHealth(getHealth() - loadWeight/1000);
        }
        if(getHealth()<30) {
            setMileage(getMileage() + 20000);
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

class Motorcycle extends Vehicle {

    public Motorcycle(String modelName) {
        super(modelName);
    }

    public Motorcycle(String modelName, int mileage, int health) {
        super(modelName, mileage, health);
    }

    @Override
    public String service() {
        return "Lubricating the chain for " + getModelName() + "\nMileage: " + getMileage() + "\nHealth: " + getHealth();
    }

    @Override
    public int expectedLifespan() {
        return 50000;
    }

    public void race(int raceMiles) {
        setMileage(getMileage()+raceMiles);
        setHealth(getHealth()-raceMiles/1000);

        if(getHealth()<40) {
            setMileage(getMileage() + 5000);
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

class Main {
    public static void main(String[] args) {
        List<Vehicle> vehicles = new ArrayList<>();

        vehicles.add(new Car("Toyota Corolla", 50000,80));
        vehicles.add(new Truck("Ford F150", 120000, 70));
        vehicles.add(new Motorcycle("Harley Davidson", 20000, 90));

        System.out.println("Vehicles at the beginning ");
        for(Vehicle vehicle : vehicles){
            System.out.println(vehicle);
        }
        System.out.println("Vehicles after a some driving ");
        for(Vehicle vehicle : vehicles) {
            vehicle.service();
            vehicle.simulateYear();

            if(vehicle instanceof Car) {
                Car car = (Car) vehicle;
                car.drive(10000);
            } else if (vehicle instanceof Truck) {
                Truck truck = (Truck) vehicle;
                truck.haul(6000);
            } else if (vehicle instanceof Motorcycle) {
                Motorcycle motorcycle = (Motorcycle) vehicle;
                motorcycle.race(500);
            }
            System.out.println(vehicle);
        }

        Scanner reader = new Scanner(System.in);
        System.out.println("Enter the vehicle index to perform maintenance: ");
        for (int i = 0; i < vehicles.size(); i++) {
            System.out.println(i + ". " + vehicles.get(i).getModelName());
        }

        int choice = reader.nextInt();
        if(choice >= 0 && choice < vehicles.size()) {
            Vehicle selectedVehicle = vehicles.get(choice);
            selectedVehicle.performMaintenance(selectedVehicle);
            System.out.println("Maintenance performed for " + selectedVehicle.getModelName());
        } else {
            System.out.println("Invalid choice");
        }
        System.out.println("Vehicles after maintenance ");
        for(Vehicle vehicle : vehicles){
            System.out.println(vehicle);
        }
    }
}

