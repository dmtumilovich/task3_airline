package by.epam.task3.main;

import by.epam.task3.entity.airline.Airline;
import by.epam.task3.entity.airplane.Airplane;

import java.util.List;

public class PrintAirlineInfo {

    public static void print(Airline airline) {
        List<Airplane> airplanes = airline.getAirplanes();
        print(airplanes);
    }

    public static void print(List<Airplane> airplanes) {
        for(Airplane airplane : airplanes) {
            System.out.println(airplane);
            System.out.println("----------------------------------");
        }
    }
}
