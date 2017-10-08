package by.tc.task01.entity;

import java.util.Objects;

public class TabletPC extends Appliance {

    private double batteryCapacity;

    private double displayInches;

    private int memoryRom;

    private int flashMemoryCapacity;

    private String color;

    public TabletPC() {
    }

    public double getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(double batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public double getDisplayInches() {
        return displayInches;
    }

    public void setDisplayInches(double displayInches) {
        this.displayInches = displayInches;
    }

    public int getMemoryRom() {
        return memoryRom;
    }

    public void setMemoryRom(int memoryRom) {
        this.memoryRom = memoryRom;
    }

    public int getFlashMemoryCapacity() {
        return flashMemoryCapacity;
    }

    public void setFlashMemoryCapacity(int flashMemoryCapacity) {
        this.flashMemoryCapacity = flashMemoryCapacity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TabletPC)) return false;
        TabletPC tabletPC = (TabletPC) o;
        return Double.compare(tabletPC.getBatteryCapacity(), getBatteryCapacity()) == 0 &&
                Double.compare(tabletPC.getDisplayInches(), getDisplayInches()) == 0 &&
                getMemoryRom() == tabletPC.getMemoryRom() &&
                getFlashMemoryCapacity() == tabletPC.getFlashMemoryCapacity() &&
                Objects.equals(getColor(), tabletPC.getColor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBatteryCapacity(), getDisplayInches(), getMemoryRom(), getFlashMemoryCapacity(), getColor());
    }

    @Override
    public String toString() {
        return "TabletPC{" +
                "batteryCapacity=" + batteryCapacity +
                ", displayInches=" + displayInches +
                ", memoryRom=" + memoryRom +
                ", flashMemoryCapacity=" + flashMemoryCapacity +
                ", color='" + color + '\'' +
                '}';
    }
}
