import java.util.Random;

public class FireSensor implements Sensor {

    private double batteryPercentage = 100.00;
    private String location;

    public FireSensor(String sensorLocation) {
        location = sensorLocation;
    }

    /**
     * Return true 5% of the time.
     * Drain 10% of the battery life when drained.
     *
     * @return boolean
     */
    @Override
    public boolean isTriggered() {

        // If the battery is zero the sensor mus tbe off
        if (batteryPercentage == 0.00) {
            return false;
        }

        batteryPercentage = batteryPercentage - 10.00;

        Random randomNum = new Random();

        if (randomNum.nextInt(100) < 5) {
            return true;
        }

        return false;
    }

    @Override
    public String getLocation() {
        return location;
    }

    @Override
    public String getSensorType() {
        return "fire sensor";
    }

    @Override
    public double getBatteryPercentage() {
        return batteryPercentage;
    }
}
