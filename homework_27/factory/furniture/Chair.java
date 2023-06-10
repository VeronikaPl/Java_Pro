package factory.furniture;

import factory.Furniture;

public class Chair implements Furniture {
    @Override
    public String create() {
        return "Create Chair";
    }
}
