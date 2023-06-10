package factory;

import factory.furniture.Chair;

public class ChairCreator extends FurnitureFactory {
    @Override
    public Furniture createFurnitureObj() {
        return new Chair();
    }
}
