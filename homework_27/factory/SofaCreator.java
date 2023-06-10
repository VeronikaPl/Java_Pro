package factory;

import factory.furniture.Sofa;

public class SofaCreator extends FurnitureFactory {
    @Override
    public Furniture createFurnitureObj() {
        return new Sofa();
    }
}
