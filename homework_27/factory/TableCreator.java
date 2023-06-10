package factory;

import factory.furniture.Table;

public class TableCreator extends FurnitureFactory {
    @Override
    public Furniture createFurnitureObj() {
        return new Table();
    }
}
