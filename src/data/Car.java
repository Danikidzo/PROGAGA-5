package data;

public final class Car {
    private boolean cool;

    private Car() {
        //private constructor
    }

    @Override
    public String toString() {
        return "Car" +
                "\ncool=" + cool;
    }

    public static CarBuilder newBuilder() {
        return new Car().new CarBuilder();
    }

    public final class CarBuilder {
        private CarBuilder() {
            //private construction
        }
        public CarBuilder cool(boolean cool) {
            Car.this.cool = cool;
            return this;
        }
        public Car build() {return  Car.this;}
    }
}
