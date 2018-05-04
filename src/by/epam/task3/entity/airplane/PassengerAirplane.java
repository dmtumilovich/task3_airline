package by.epam.task3.entity.airplane;

public class PassengerAirplane extends TransportAirplane {
    protected final int passengerCapacity;

    private PassengerAirplane(Builder builder) {
        super(builder);
        passengerCapacity = builder.passengerCapacity;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public String toString() {
        String str = super.toString();
        StringBuilder builder = new StringBuilder(str);
        builder.append(", ").append("passenger capacity = ").append(passengerCapacity);
        return builder.toString();
    }

    public static class Builder extends AirplaneBuilder<PassengerAirplane> {

        protected int passengerCapacity;

        public Builder setPassengerCapacity(int passengerCapacity) {
            this.passengerCapacity = passengerCapacity;
            return this;
        }

        @Override
        public void reset() {
            super.reset();
            passengerCapacity = 0;
        }

        @Override
        public PassengerAirplane build() {
            return new PassengerAirplane(this);
        }
    }
}
