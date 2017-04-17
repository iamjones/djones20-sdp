package java.alarmsystem;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SmokeSensorTest {

    private Sensor smokeSensor;

    @Before
    public void setUp() {
        smokeSensor = new SmokeSensor("kitchen");
    }

    @Test
    public void testThatIsTriggeredReturnsFalse() {
        boolean isTriggered = smokeSensor.isTriggered();
        assertEquals(false, isTriggered);
    }

    @Test
    public void testThatGetLocationReturnsKitchen() {
        String location = smokeSensor.getLocation();
        assertEquals("kitchen", location);

    }

    @Test
    public void testThatGetSensorTypeReturnsSmoke() {
        String sensorType = smokeSensor.getSensorType();
        assertEquals("smoke sensor", sensorType);
    }

    @Test
    public void testThatGetBatteryPercentageIsReducedBy20OnEachCall() {

        assertEquals(100.00, smokeSensor.getBatteryPercentage(), 0.01);

        smokeSensor.isTriggered();

        assertEquals(80.00, smokeSensor.getBatteryPercentage(), 0.01);
    }

}
