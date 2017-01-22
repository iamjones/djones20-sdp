import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FireSensorTest {

    private Sensor fireSensor;

    @Before
    public void setUp() {
        fireSensor = new FireSensor("kitchen");
    }

    @Test
    public void testThatIsTriggeredReturnsFalse() {
        boolean isTriggered = fireSensor.isTriggered();
        assertEquals(false, isTriggered);
    }

    @Test
    public void testThatGetLocationReturnsNull() {
        String location = fireSensor.getLocation();
        assertEquals("kitchen", location);
    }

    @Test
    public void testThatGetSensorTypeReturnsFireSensor() {
        String sensorType = fireSensor.getSensorType();
        assertEquals("fire sensor", sensorType);
    }

    @Test
    public void testThatGetBatteryPercentageReturnsFull() {
        double batteryPercentage = fireSensor.getBatteryPercentage();
        assertEquals(100.00, batteryPercentage, 0.01);
    }
}
