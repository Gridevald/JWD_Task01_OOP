package by.tc.task01.entity;

import java.util.Objects;

public class Speakers extends Appliance {

    private int powerConsumption;

    private int numberOfSpeakers;

    private String FrequencyRange;

    private double cordLength;

    public Speakers() {
    }

    public int getPowerConsumption() {
        return powerConsumption;
    }

    public void setPowerConsumption(int powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    public int getNumberOfSpeakers() {
        return numberOfSpeakers;
    }

    public void setNumberOfSpeakers(int numberOfSpeakers) {
        this.numberOfSpeakers = numberOfSpeakers;
    }

    public String getFrequencyRange() {
        return FrequencyRange;
    }

    public void setFrequencyRange(String frequencyRange) {
        FrequencyRange = frequencyRange;
    }

    public double getCordLength() {
        return cordLength;
    }

    public void setCordLength(double cordLength) {
        this.cordLength = cordLength;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Speakers)) return false;
        Speakers speakers = (Speakers) o;
        return getPowerConsumption() == speakers.getPowerConsumption() &&
                getNumberOfSpeakers() == speakers.getNumberOfSpeakers() &&
                Double.compare(speakers.getCordLength(), getCordLength()) == 0 &&
                Objects.equals(getFrequencyRange(), speakers.getFrequencyRange());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPowerConsumption(), getNumberOfSpeakers(), getFrequencyRange(), getCordLength());
    }

    @Override
    public String toString() {
        return "Speakers{" +
                "powerConsumption=" + powerConsumption +
                ", numberOfSpeakers=" + numberOfSpeakers +
                ", FrequencyRange='" + FrequencyRange + '\'' +
                ", cordLength=" + cordLength +
                '}';
    }
}
