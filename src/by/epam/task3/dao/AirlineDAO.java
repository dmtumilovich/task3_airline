package by.epam.task3.dao;

import by.epam.task3.entity.airplane.Airplane;
import java.util.List;

public class AirlineDAO {

    //сменить название
    public List<Airplane> getAirplanesFromJSON(String filename) {

        JsonAirplanesParser airplanesParser = new JsonAirplanesParser(filename);
        List<Airplane> airplanes = airplanesParser.parseForAirplanes();

        return airplanes;
    }

}
