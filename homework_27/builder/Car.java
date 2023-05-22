package builder;

import builder.car_components.CarType;
import builder.car_components.Engine;
import builder.car_components.Transmission;

import java.util.Objects;

public class Car {
    private final CarType carType;
    private final Engine engine;
    private final Transmission transmission;

    public Car(CarType carType, Engine engine, Transmission transmission) {
        this.carType = carType;
        this.engine = engine;
        this.transmission = transmission;
    }

    public CarType getCarType() {
        return carType;
    }

    public Engine getEngine() {
        return engine;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return carType == car.carType && Objects.equals(engine, car.engine) && transmission == car.transmission;
    }

    @Override
    public int hashCode() {
        return Objects.hash(carType, engine, transmission);
    }

    @Override
    public String toString() {
        return "Car{" +
                "carType=" + carType +
                ", engine=" + engine +
                ", transmission=" + transmission +
                '}';
    }
}
