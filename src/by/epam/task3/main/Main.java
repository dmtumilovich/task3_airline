package by.epam.task3.main;

import by.epam.task3.entity.airline.Airline;
import by.epam.task3.entity.airplane.Airplane;
import by.epam.task3.entity.airplane.CargoAirplane;
import by.epam.task3.entity.airplane.PassengerAirplane;
import by.epam.task3.service.AirlineService;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        PassengerAirplane.Builder passengerBuilder = new PassengerAirplane.Builder();
        CargoAirplane.Builder cargoBuilder = new CargoAirplane.Builder();

        Airplane pas1 = (Airplane) passengerBuilder.setPassengerCapacity(100).setModelName("Boeing-737").setRangeOfFlight(4000).setFuelConsumption(200).build();
        passengerBuilder.reset();
        Airplane pas2 = (Airplane) passengerBuilder.setPassengerCapacity(150).setModelName("Boeing-747").setRangeOfFlight(3000).setFuelConsumption(99).build();
        passengerBuilder.reset();
        Airplane pas3 = (Airplane) passengerBuilder.setPassengerCapacity(90).setModelName("Boeing-727").setRangeOfFlight(1000).setFuelConsumption(132).build();
        passengerBuilder.reset();


        Airplane cargo1 = (Airplane) cargoBuilder.setCarryingCapacity(100.0).setModelName("Cargo231").setRangeOfFlight(3500).setFuelConsumption(140).build();

        Airline airline = new Airline("QatarAirlines");
        airline.add(pas1);
        airline.add(pas2);
        airline.add(pas3);
        airline.add(cargo1);

        PrintAirlineInfo.print(airline);
        System.out.println("************");

        AirlineService service = new AirlineService();

        service.sortByRange(airline, Airline.RANGE_ASCENDING_ORDER);
        PrintAirlineInfo.print(airline);
        System.out.println("*************");

        service.sortByRange(airline, Airline.RANGE_DESCENDING_ORDER);
        PrintAirlineInfo.print(airline);
        System.out.println("**********");


        List<Airplane> matches = service.findByFuelConsumption(airline, 100, 200);
        PrintAirlineInfo.print(matches);

    }
}
