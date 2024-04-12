package data;

import java.io.Serializable;

public final class Coordinates implements Serializable {
    private long x;
    private Float y; //Поле не может быть null

    private Coordinates() {
        //private construction
    }

    @Override
    public String toString() {
        return "\n\tx=" + x
                + "\n\ty=" + y
                + "\n";
    }

    public static CoordinatesBuilder newBuilder() {
        return new Coordinates().new CoordinatesBuilder();
    }

    public final class CoordinatesBuilder {
        private CoordinatesBuilder() {
            //private construction
        }
        public CoordinatesBuilder setX(long x) {
            Coordinates.this.x = x;
            return this;
        }
        public CoordinatesBuilder setY(Float y) {
            Coordinates.this.y = y;
            return this;
        }
        public Coordinates build() {
            return Coordinates.this;
        }
    }
}

