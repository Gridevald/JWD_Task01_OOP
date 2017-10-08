package by.tc.task01.entity;

import java.util.Objects;

public class VacuumCleaner extends Appliance {

    private int powerConsumption;

    private String filterType;

    private String bagType;

    private String wandType;

    private int motorSpeedRegulation;

    private int cleaningWidth;

    public VacuumCleaner() {
    }

    public int getPowerConsumption() {
        return powerConsumption;
    }

    public void setPowerConsumption(int powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    public String getFilterType() {
        return filterType;
    }

    public void setFilterType(String filterType) {
        this.filterType = filterType;
    }

    public String getBagType() {
        return bagType;
    }

    public void setBagType(String bagType) {
        this.bagType = bagType;
    }

    public String getWandType() {
        return wandType;
    }

    public void setWandType(String wandType) {
        this.wandType = wandType;
    }

    public int getMotorSpeedRegulation() {
        return motorSpeedRegulation;
    }

    public void setMotorSpeedRegulation(int motorSpeedRegulation) {
        this.motorSpeedRegulation = motorSpeedRegulation;
    }

    public int getCleaningWidth() {
        return cleaningWidth;
    }

    public void setCleaningWidth(int cleaningWidth) {
        this.cleaningWidth = cleaningWidth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VacuumCleaner)) return false;
        VacuumCleaner that = (VacuumCleaner) o;
        return getPowerConsumption() == that.getPowerConsumption() &&
                getMotorSpeedRegulation() == that.getMotorSpeedRegulation() &&
                getCleaningWidth() == that.getCleaningWidth() &&
                Objects.equals(getFilterType(), that.getFilterType()) &&
                Objects.equals(getBagType(), that.getBagType()) &&
                Objects.equals(getWandType(), that.getWandType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPowerConsumption(), getFilterType(), getBagType(), getWandType(), getMotorSpeedRegulation(), getCleaningWidth());
    }

    @Override
    public String toString() {
        return "VacuumCleaner{" +
                "powerConsumption=" + powerConsumption +
                ", filterType='" + filterType + '\'' +
                ", bagType='" + bagType + '\'' +
                ", wandType='" + wandType + '\'' +
                ", motorSpeedRegulation=" + motorSpeedRegulation +
                ", cleaningWidth=" + cleaningWidth +
                '}';
    }
}
