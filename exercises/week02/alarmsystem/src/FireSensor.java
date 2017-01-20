public class FireSensor implements Sensor {

    private double batteryPercentage = 100;
    private String sensorType        = "fire";
    private String location          = "";

    @Override
    public boolean isTriggered() {

        return false;
    }

    @Override
    public String getLocation() {

        return null;
    }

    @Override
    public String getSensorType() {
        return sensorType;
    }

    @Override
    public double getBatteryPercentage() {
        return batteryPercentage;
    }
}
