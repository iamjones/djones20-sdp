package java.alarmsystem;

import java.util.List;

public class ControlUnit {

    public void pollSensors(List<Sensor> sensors) {

        for (Sensor sensor : sensors) {
            if (sensor.isTriggered()) {
                System.out.println("A " + sensor.getSensorType() + " sensor was triggered at " + sensor.getLocation());
            } else {
                System.out.println("Polled " + sensor.getSensorType() + " at " + sensor.getLocation() + " successfully");
            }
        }
    }
}
