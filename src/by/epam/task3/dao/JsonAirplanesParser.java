package by.epam.task3.dao;

import by.epam.task3.entity.airplane.Airplane;
import by.epam.task3.entity.airplane.CargoAirplane;
import by.epam.task3.entity.airplane.PassengerAirplane;
import by.epam.task3.entity.airplane.factory.AirplaneBuilderFactory;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonAirplanesParser {
    private final String filename;

    private static final String KEY_AIRPLANES = "airplanes";
    private static final String KEY_TYPE = "type";
    private static final String KEY_MODEL_NAME = "modelName";
    private static final String KEY_COST = "cost";
    private static final String KEY_RANGE_OF_FLIGHT = "rangeOfFlight";
    private static final String KEY_MAX_HEIGHT = "maxHeight";
    private static final String KEY_MAX_SPEED = "maxSpeed";
    private static final String KEY_FUEL_CONSUMPTION = "fuelConsumption";

    public JsonAirplanesParser(String filename) {
        this.filename = filename;
    }

    public List<Airplane> parseForAirplanes() {

        List<Airplane> airplanes;
        String jsonString = getJsonString(filename);
        airplanes = getAirplanesFromJsonString(jsonString);

        return airplanes;
    }

    private List<Airplane> getAirplanesFromJsonString(String jsonString) {
        List<Airplane> airplanes = new ArrayList<>();
        AirplaneBuilderFactory builderFactory = new AirplaneBuilderFactory();

        JSONObject rootObject = new JSONObject(jsonString);

        JSONArray airplanesArray = rootObject.getJSONArray(KEY_AIRPLANES);
        for(int i = 0; i < airplanesArray.length(); i++) {
            JSONObject airplaneObject = airplanesArray.getJSONObject(i);

            String type = airplaneObject.getString(KEY_TYPE);
            Airplane.AirplaneBuilder builder = builderFactory.createAirplaneBuilder(type);

            builder.setModelName(airplaneObject.getString(KEY_MODEL_NAME));
            builder.setCost(airplaneObject.getDouble(KEY_COST));
            builder.setRangeOfFlight(airplaneObject.getInt(KEY_RANGE_OF_FLIGHT));
            builder.setMaxHeight(airplaneObject.getDouble(KEY_MAX_HEIGHT));
            builder.setMaxSpeed(airplaneObject.getDouble(KEY_MAX_SPEED));
            builder.setFuelConsumption(airplaneObject.getDouble(KEY_FUEL_CONSUMPTION));

            if(type.equals("passenger")) {
                ((PassengerAirplane.Builder) builder).setPassengerCapacity(airplaneObject.getInt("passengerCapacity"));
            } else if(type.equals("cargo")) {
                ((CargoAirplane.Builder) builder).setCarryingCapacity(airplaneObject.getDouble("carryingCapacity"));
            }

            Airplane airplane = (Airplane) builder.build();
            airplanes.add(airplane);

        }

        return airplanes;
    }

    private String getJsonString(String filename) {
        StringBuilder jsonStringBuilder = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {

            String line;
            while((line = reader.readLine()) != null) {
                jsonStringBuilder.append(line);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return jsonStringBuilder.toString();
    }
}
