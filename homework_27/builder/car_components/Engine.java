package builder.car_components;

import java.util.Objects;

public class Engine {
    private final double volume;

    public Engine(double volume) {
        this.volume = volume;
    }

    public double getVolume() {
        return volume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Engine engine = (Engine) o;
        return Double.compare(engine.volume, volume) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(volume);
    }

    @Override
    public String toString() {
        return "Engine{" +
                "volume=" + volume +
                '}';
    }
}
