package by.epam.task3.main;

import by.epam.task3.dao.AirlineDAO;
import by.epam.task3.entity.airline.Airline;
import by.epam.task3.entity.airplane.Airplane;
import by.epam.task3.entity.airplane.CargoAirplane;
import by.epam.task3.entity.airplane.PassengerAirplane;
import by.epam.task3.service.AirlineService;
import by.epam.task3.service.ServiceFactory;

import java.util.List;

public class Main {

    private static final String FILE_NAME = "src/res/query.json";

    public static void main(String[] args) {

        Airline airline = new Airline("Qatar Airlines");

        AirlineService service = ServiceFactory.getInstance().getAirlineService();

        List<Airplane> airplanes = service.getAirplanesFromFile(FILE_NAME);
        airline.setAirplanes(airplanes);

        PrintAirlineInfo.print(airline);
        System.out.println("**********");

        service.sortByRange(airline, Airline.RANGE_DESCENDING_ORDER);
        System.out.println("Sorted: ");
        PrintAirlineInfo.print(airline);
        System.out.println("**********");

        int totalPassengerCapacity = service.calculateTotalPassengerCapacity(airline);
        double totalCarryingCapacity = service.calculateTotalCarryingCapacity(airline);
        System.out.println("Total passenger capacity is " + totalPassengerCapacity);
        System.out.println("Total carrying capacity is " + totalCarryingCapacity);
        System.out.println("**********");

        List<Airplane> fuelMatches = service.findByFuelConsumption(airline, 150, 250);
        PrintAirlineInfo.print(fuelMatches);
        System.out.println("**********");

    }
}
