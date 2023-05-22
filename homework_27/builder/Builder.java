package builder;

import builder.car_components.Engine;
import builder.car_components.CarType;
import builder.car_components.Transmission;

public interface Builder {
    void setCarType(CarType type);

    void setEngine(Engine engine);

    void setTransmission(Transmission transmission);
}
