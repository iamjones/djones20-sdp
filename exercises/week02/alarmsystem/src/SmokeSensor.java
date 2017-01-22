import java.util.Random;

public class SmokeSensor implements Sensor {

    private double batteryPercentage = 100.00;
    private String location;

    public SmokeSensor(String sensorLocation) {
        location = sensorLocation;
    }

    /**
     * 10% of the times it raises an alarm.
     * 20% of battery is reduced on each call.
     *
     * @return boolean
     */
    @Override
    public boolean isTriggered() {

        if (batteryPercentage == 0.00) {
            return false;
        }

        batteryPercentage = batteryPercentage - 20.00;

        Random randomNum = new Random();

        if (randomNum.nextInt(100) < 10) {
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
        return "smoke sensor";
    }

    @Override
    public double getBatteryPercentage() {
        return batteryPercentage;
    }
}
