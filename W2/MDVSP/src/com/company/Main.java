package com.company;

public class Main {

    public static void main(String[] args) {
        Problem problem = new Problem();

        Client[] clients = new Client[6];
        clients[0] = new Client("C1", 1);
        clients[1] = new Client("C2", 1);
        clients[2] = new Client("C3", 2);
        clients[3] = new Client("C4", 2);
        clients[4] = new Client("C5", 3);

        problem.setClients(clients);

        Vehicle[] vehicles = new Vehicle[3];
        vehicles[0] = new Vehicle("V1", VehicleType.CAR);
        vehicles[1] = new Vehicle("V2", VehicleType.CAR);
        vehicles[2] = new Vehicle("V3", VehicleType.DRONE);

        Depot[] depots = new Depot[2];
        depots[0] = new Depot("D1");
        depots[0].setVehicles(vehicles[0], vehicles[1]);

        depots[1] = new Depot("D2");
        depots[1].setVehicles(vehicles[2]);

        problem.setDepots(depots);

        System.out.println(problem.toString());

        Tour[] tours = new Tour[3];
        tours[0] = new Tour();
        tours[0].setVehicle(vehicles[0]);
        tours[0].setClients(clients[0], clients[2], clients[4]);

        tours[1] = new Tour();
        tours[1].setVehicle(vehicles[1]);
        tours[1].setClients(clients[1]);

        tours[2] = new Tour();
        tours[2].setVehicle(vehicles[2]);
        tours[2].setClients(clients[3]);

        for (Tour tour : tours) {
            System.out.println(tour.toString());
        }
    }
}
