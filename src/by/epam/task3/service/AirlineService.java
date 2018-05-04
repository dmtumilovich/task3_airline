package by.epam.task3.service;

import by.epam.task3.entity.airline.Airline;
import by.epam.task3.entity.airplane.Airplane;
import by.epam.task3.entity.airplane.CargoAirplane;
import by.epam.task3.entity.airplane.PassengerAirplane;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AirlineService {

    public void sortByRange(Airline airline, Comparator<? super Airplane> comparator) {
        Collections.sort(airline.getAirplanes(), comparator);
    }

    public int calculateTotalPassengerCapacity(Airline airline) {
        List<Airplane> airplanes = airline.getAirplanes();
        int totalPassengerCapacity = 0;

        for(Airplane airplane : airplanes) {
            if (airplane instanceof PassengerAirplane) {
                int passengerCapacity = ((PassengerAirplane) airplane).getPassengerCapacity();
                totalPassengerCapacity += passengerCapacity;
            }
        }

        return totalPassengerCapacity;
    }

    public List<Airplane> findByFuelConsumption(Airline airline, double from, double to) {
        List<Airplane> matches = new ArrayList<>();

        for(Airplane airplane : airline.getAirplanes()) {
            double fuelConsumption = airplane.getFuelConsumption();
            if(fuelConsumption >= from && fuelConsumption <= to) {
                matches.add(airplane);
            }
        }

        return matches;
    }

    public double calculateTotalCarryingCapacity(Airline airline) {
        List<Airplane> airplanes = airline.getAirplanes();
        double totalCarryingCapacity = 0;

        for(Airplane airplane : airplanes) {
            if(airplane instanceof CargoAirplane) {
                double carryingCapacity = ((CargoAirplane) airplane).getCarryingCapacity();
                totalCarryingCapacity += carryingCapacity;
            }
        }

        return totalCarryingCapacity;
    }
}
