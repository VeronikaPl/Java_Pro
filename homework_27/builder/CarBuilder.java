package builder;

import builder.car_components.CarType;
import builder.car_components.Engine;
import builder.car_components.Transmission;

public class CarBuilder implements Builder {
    private CarType type;
    private Engine engine;
    private Transmission transmission;

    public void setCarType(CarType type) {
        this.type = type;
    }

    @Override
    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    public Car getResult() {
        return new Car(type, engine, transmission);
    }
}
