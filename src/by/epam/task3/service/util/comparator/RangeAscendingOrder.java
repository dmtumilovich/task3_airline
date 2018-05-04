package by.epam.task3.service.util.comparator;

import by.epam.task3.entity.airplane.Airplane;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class RangeAscendingOrder implements Comparator<Airplane> {
    @Override
    public int compare(Airplane a1, Airplane a2) {
        double rangeOfFlight1 = a1.getRangeOfFlight();
        double rangeOfFlight2 = a2.getRangeOfFlight();
        return Double.compare(rangeOfFlight1, rangeOfFlight2);
    }
}
