package by.tc.task01.entity;

import java.util.Objects;

public class Oven extends Appliance {

    private int powerConsumption;

    private double weight;

    private double capacity;

    private double depth;

    private double height;

    private double width;

    public Oven() {
    }

    public int getPowerConsumption() {
        return powerConsumption;
    }

    public void setPowerConsumption(int powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public double getDepth() {
        return depth;
    }

    public void setDepth(double depth) {
        this.depth = depth;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Oven)) return false;
        Oven oven = (Oven) o;
        return getPowerConsumption() == oven.getPowerConsumption() &&
                Double.compare(oven.getWeight(), getWeight()) == 0 &&
                Double.compare(oven.getCapacity(), getCapacity()) == 0 &&
                Double.compare(oven.getDepth(), getDepth()) == 0 &&
                Double.compare(oven.getHeight(), getHeight()) == 0 &&
                Double.compare(oven.getWidth(), getWidth()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPowerConsumption(), getWeight(), getCapacity(), getDepth(), getHeight(), getWidth());
    }

    @Override
    public String toString() {
        return "Oven{" +
                "powerConsumption=" + powerConsumption +
                ", weight=" + weight +
                ", capacity=" + capacity +
                ", depth=" + depth +
                ", height=" + height +
                ", width=" + width +
                '}';
    }
}
