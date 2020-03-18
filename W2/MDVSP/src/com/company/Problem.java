package com.company;

import java.util.Arrays;

public class Problem {

    private Depot[] depots;
    private Client[] clients;

    public Depot[] getDepots() {
        return depots;
    }

    public Client[] getClients() {
        return clients;
    }

    public void setDepots(Depot ... depots) {
        this.depots = depots;
    }

    public void setClients(Client ... clients) {
        this.clients = clients;
    }

    @Override
    public String toString() {
        return "Problem{" +
                "depots=" + Arrays.toString(depots) +
                ", clients=" + Arrays.toString(clients) +
                '}';
    }
}
