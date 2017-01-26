3)
This method is used to create a list containing one fire and one smoke sensor.
It also loops through each one and prints a different message if it is triggered
and if it is not triggered.

5)
This now only loops through the sensors and checks if they are triggered.
It is no longer responsible for creating them.

6)
This breaks the Liskov substitute principle. The interface of sensor will not hold for all
its subtypes. If the alarm systems for hazards implement the current sensor interface the 
getBatteryPercentage method will not be used. 
   