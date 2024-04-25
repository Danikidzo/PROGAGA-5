package data;

import java.util.Objects;

public final class Car {
    private boolean cool;

    @Override
    public String toString() {
        return "Car" +
                "\ncool=" + cool;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return cool == car.cool;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(cool);
    }

    public static CarBuilder newBuilder() {
        return new Car().new CarBuilder();
    }

    public final class CarBuilder {
        public CarBuilder cool(boolean cool) {
            Car.this.cool = cool;
            return this;
        }
        public Car build() {return  Car.this;}
    }
}
