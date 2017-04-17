import java.alarmsystem.ControlUnit;
import java.alarmsystem.FireSensor;
import java.alarmsystem.Sensor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private static final String EXIT = "exit";
    private static final String POLL = "poll";

    public static void main(String[] args) throws IOException {
        ControlUnit controlUnit = new ControlUnit();

        Scanner scanner = new Scanner(System.in);
        String input = "";
        while (!input.equals(EXIT)) {
            System.out.println("Type \"poll\" to poll all sensors once or \"exit\" to exit");
            input = scanner.nextLine();
            if (input.equals(POLL)) {

                List<Sensor> sensors = new ArrayList<>();
                sensors.add(new FireSensor("bedroom"));

                controlUnit.pollSensors(sensors);
            }
        }
    }
}
