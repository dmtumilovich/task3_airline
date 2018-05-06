package by.epam.task3.entity.airplane.factory;

import by.epam.task3.entity.airplane.Airplane;
import by.epam.task3.entity.airplane.CargoAirplane;
import by.epam.task3.entity.airplane.PassengerAirplane;

public class AirplaneBuilderFactory {

    public Airplane.AirplaneBuilder createAirplaneBuilder(String type) {
        switch (type) {
            case "passenger":
                return new PassengerAirplane.Builder();
            case "cargo":
                return new CargoAirplane.Builder();
                default:
                    return null;
        }
    }

}
