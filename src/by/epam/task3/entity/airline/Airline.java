package by.epam.task3.entity.airline;

import by.epam.task3.entity.airplane.Airplane;

import java.util.ArrayList;
import java.util.List;
import by.epam.task3.service.util.comparator.RangeAscendingOrder;
import by.epam.task3.service.util.comparator.RangeDescendingOrder;

public class Airline {
    public static RangeAscendingOrder RANGE_ASCENDING_ORDER = new RangeAscendingOrder();
    public static RangeDescendingOrder RANGE_DESCENDING_ORDER = new RangeDescendingOrder();

    protected String companyName;
    protected List<Airplane> airplanes = new ArrayList<>();

    public Airline(String name) {
        companyName = name;
    }

    public List<Airplane> getAirplanes() {
        return airplanes;
    }

    public void add(Airplane airplane) {
        airplanes.add(airplane);
    }
}
