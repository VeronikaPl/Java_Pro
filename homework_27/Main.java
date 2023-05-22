import builder.CarBuilder;
import builder.CarDirector;
import factory.ChairCreator;
import factory.FurnitureFactory;
import factory.SofaCreator;
import factory.TableCreator;
import strategy.Rectangle;
import strategy.SquareCalculate;
import strategy.Triangle;

public class Main {
    public static void main(String[] args) {
        System.out.println("\tSquare (Strategy):");
        SquareCalculate squareCalculate = new SquareCalculate();

        Rectangle rectangle = new Rectangle(3, 7);
        squareCalculate.setGeometricFigure(rectangle);
        System.out.println("Rectangle (3, 7) = " + squareCalculate.calculateFigureSquare());

        Triangle triangle = new Triangle(8, 5);
        squareCalculate.setGeometricFigure(triangle);
        System.out.println("Triangle (8, 5) = " + squareCalculate.calculateFigureSquare());

        System.out.println("\tFurniture (Factory):");
        FurnitureFactory sofaCreator = new SofaCreator();
        System.out.println(sofaCreator.createFurniture());

        FurnitureFactory chairCreator = new ChairCreator();
        System.out.println(chairCreator.createFurniture());

        FurnitureFactory tableCreator = new TableCreator();
        System.out.println(tableCreator.createFurniture());

        System.out.println("\tCar factory (Builder):");
        CarDirector carDirector = new CarDirector();
        CarBuilder carBuilder = new CarBuilder();

        carDirector.constructCityCar(carBuilder);
        System.out.println(carBuilder.getResult());

        carDirector.constructSportsCar(carBuilder);
        System.out.println(carBuilder.getResult());

        carDirector.constructSUV(carBuilder);
        System.out.println(carBuilder.getResult());
    }
}
