package factory.furniture;

import factory.Furniture;

public class Table implements Furniture {
    @Override
    public String create() {
        return "Create Table";
    }
}
