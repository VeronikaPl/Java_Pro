package factory.furniture;

import factory.Furniture;

public class Sofa implements Furniture {
    @Override
    public String create() {
        return "Create Sofa";
    }
}
