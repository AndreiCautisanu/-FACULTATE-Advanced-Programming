import java.util.*;

public class Hospital implements Comparable<Hospital> {
    private String name;
    private int capacity;

    public Hospital(String name) {
        this.name = name;
    }

    public Hospital(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Hospital{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Hospital h) {
        return this.getName().compareTo(h.getName());
    }
}
