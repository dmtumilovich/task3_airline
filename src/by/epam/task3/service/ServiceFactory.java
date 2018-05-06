package by.epam.task3.service;


public class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();
    protected final AirlineService airlineService = new AirlineService();

    private ServiceFactory() {

    }

    public AirlineService getAirlineService() {
        return airlineService;
    }

    public static ServiceFactory getInstance() {
        return instance;
    }
}
