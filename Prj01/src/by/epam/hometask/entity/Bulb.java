package by.epam.hometask.entity;

public class Bulb {
    private int illuminance;

    public Bulb(int illuminance) {
        this.illuminance = illuminance;
    }

    public int getIlluminance() {
        return illuminance;
    }

    public void setIlluminance(int illuminance) {
        this.illuminance = illuminance;
    }

    @Override
    public String toString() {
        return "Bulb{" +
                "illuminance=" + illuminance +
                '}';
    }
}
