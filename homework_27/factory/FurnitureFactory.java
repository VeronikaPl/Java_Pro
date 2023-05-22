package factory;

public abstract class FurnitureFactory {
    public abstract Furniture createFurnitureObj();

    public String createFurniture() {
        Furniture furniture = createFurnitureObj();
        return furniture.create();
    }
}
