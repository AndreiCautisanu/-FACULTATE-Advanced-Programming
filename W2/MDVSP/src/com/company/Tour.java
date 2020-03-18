package com.company;

public class Tour {

    private Vehicle vehicle;
    private Client[] clients;

    public Tour() { }

    public Tour(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Client[] getClients() {
        return clients;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void setClients(Client ... clients) {
        this.clients = clients;
    }

    @Override
    public String toString() {
        StringBuilder clientsTour = new StringBuilder();
        clientsTour.append(clients[0].getName());

        for (int i = 1; i < clients.length; i++) {
            clientsTour.append(" - > ");
            clientsTour.append(clients[i].getName());
        }

        return vehicle.getName() + " : " +
                vehicle.getDepot().getName() + " -> " + clientsTour.toString() + " -> " +
                vehicle.getDepot().getName();
    }
}
