package by.epam.task3.entity.airplane;

public class CargoAirplane extends TransportAirplane {
    protected final double carryingCapacity;


    protected CargoAirplane(Builder builder) {
        super(builder);
        carryingCapacity = builder.carryingCapacity;
    }

    public double getCarryingCapacity() {
        return carryingCapacity;
    }

    public String toString() {
        String str = super.toString();
        StringBuilder builder = new StringBuilder(str);
        builder.append(", ").append("carrying capacity = ").append(carryingCapacity);
        return builder.toString();
    }

    public static class Builder extends AirplaneBuilder<CargoAirplane> {

        private double carryingCapacity;

        public Builder setCarryingCapacity(double carryingCapacity) {
            this.carryingCapacity = carryingCapacity;
            return this;
        }

        @Override
        public void reset() {
            super.reset();
            carryingCapacity = 0;
        }

        @Override
        public CargoAirplane build() {
            return new CargoAirplane(this);
        }
    }
}
