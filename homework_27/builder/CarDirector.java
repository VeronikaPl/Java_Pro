package builder;

import builder.car_components.CarType;
import builder.car_components.Engine;
import builder.car_components.Transmission;

import java.util.Objects;

public class CarDirector {
    public void constructSportsCar(Builder builder) {
        Objects.requireNonNull(builder);
        builder.setCarType(CarType.SPORTS_CAR);
        builder.setEngine(new Engine(3.0));
        builder.setTransmission(Transmission.SEMI_AUTOMATIC);
    }

    public void constructCityCar(Builder builder) {
        Objects.requireNonNull(builder);
        builder.setCarType(CarType.CITY_CAR);
        builder.setEngine(new Engine(1.2));
        builder.setTransmission(Transmission.AUTOMATIC);
    }

    public void constructSUV(Builder builder) {
        Objects.requireNonNull(builder);
        builder.setCarType(CarType.SUV);
        builder.setEngine(new Engine(2.5));
        builder.setTransmission(Transmission.MANUAL);
    }
}
