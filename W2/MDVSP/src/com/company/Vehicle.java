package com.company;

public class Vehicle {

    private String name;
    private Depot depot;
    private VehicleType type;

    public Vehicle(String name, VehicleType type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public Depot getDepot() {
        return depot;
    }

    public VehicleType getType() {
        return type;
    }

    public void setName(String name) {
        this.name = name;
    }

    protected void setDepot(Depot depot) {
        this.depot = depot;
    }

    public void setType(VehicleType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "name='" + name + '\'' +
                ", depot=" + depot.getName() +
                ", type=" + type +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Vehicle)) {
            return false;
        }

        Vehicle other = (Vehicle)obj;
        return name.equals(other.getName());
    }
}
