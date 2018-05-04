package by.epam.task3.entity.airplane;

public abstract class Airplane {
    protected final String modelName;
    protected final double cost;
    protected final double rangeOfFlight;
    protected final double maxHeight;
    protected final double maxSpeed;
    protected final double fuelConsumption;

    protected Airplane(AirplaneBuilder builder) {
        modelName = builder.modelName;
        cost = builder.cost;
        rangeOfFlight = builder.rangeOfFlight;
        maxHeight = builder.maxHeight;
        maxSpeed = builder.maxSpeed;
        fuelConsumption = builder.fuelConsumption;
    }

    public String getModelName() {
        return modelName;
    }

    public double getCost() {
        return cost;
    }

    public double getRangeOfFlight() {
        return rangeOfFlight;
    }

    public double getMaxHeight() {
        return maxHeight;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Model: ").append(modelName).append("\n")
                .append("cost = ").append(cost).append(", ")
                .append("range of flight = ").append(rangeOfFlight).append(", ")
                .append("max height = ").append(maxHeight).append(", ")
                .append("max speed = ").append(maxSpeed).append(", ")
                .append("fuel consumption = ").append(fuelConsumption);
        return builder.toString();
    }



    public static abstract class AirplaneBuilder<T> {
        protected String modelName;
        protected double cost;
        protected int rangeOfFlight;
        protected double maxHeight;
        protected double maxSpeed;
        protected double fuelConsumption;

        public AirplaneBuilder setModelName(String modelName) {
            this.modelName = modelName;
            return this;
        }

        public AirplaneBuilder setCost(double cost) {
            this.cost = cost;
            return this;
        }

        public AirplaneBuilder setRangeOfFlight(int rangeOfFlight) {
            this.rangeOfFlight = rangeOfFlight;
            return this;
        }

        public AirplaneBuilder setMaxHeight(double maxHeight) {
            this.maxHeight = maxHeight;
            return this;
        }

        public AirplaneBuilder setMaxSpeed(double maxSpeed) {
            this.maxSpeed = maxSpeed;
            return this;
        }

        public AirplaneBuilder setFuelConsumption(double fuelConsumption) {
            this.fuelConsumption = fuelConsumption;
            return this;
        }

        public void reset() {
            modelName = null;
            cost = 0;
            rangeOfFlight = 0;
            maxHeight = 0;
            maxSpeed = 0;
            fuelConsumption = 0;
        }

        public abstract T build();

    }
}
