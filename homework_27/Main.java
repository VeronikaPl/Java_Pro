import builder.CarBuilder;
import builder.CarDirector;
import factory.ChairCreator;
import factory.FurnitureFactory;
import factory.SofaCreator;
import factory.TableCreator;
import strategy.Rectangle;
import strategy.SquareCalculate;
import strategy.Triangle;

import java.util.logging.Logger;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        LOGGER.info("\tSquare (Strategy):");
        SquareCalculate squareCalculate = new SquareCalculate();

        Rectangle rectangle = new Rectangle(3, 7);
        squareCalculate.setGeometricFigure(rectangle);
        LOGGER.info("Rectangle (3, 7) = " + squareCalculate.calculateFigureSquare());

        Triangle triangle = new Triangle(8, 5);
        squareCalculate.setGeometricFigure(triangle);
        LOGGER.info("Triangle (8, 5) = " + squareCalculate.calculateFigureSquare());

        LOGGER.info("\tFurniture (Factory):");
        FurnitureFactory sofaCreator = new SofaCreator();
        LOGGER.info(sofaCreator.createFurniture());

        FurnitureFactory chairCreator = new ChairCreator();
        LOGGER.info(chairCreator.createFurniture());

        FurnitureFactory tableCreator = new TableCreator();
        LOGGER.info(tableCreator.createFurniture());

        LOGGER.info("\tCar factory (Builder):");
        CarDirector carDirector = new CarDirector();
        CarBuilder carBuilder = new CarBuilder();

        carDirector.constructCityCar(carBuilder);
        LOGGER.info(String.valueOf(carBuilder.built()));

        carDirector.constructSportsCar(carBuilder);
        LOGGER.info(String.valueOf(carBuilder.built()));

        carDirector.constructSUV(carBuilder);
        LOGGER.info(String.valueOf(carBuilder.built()));
    }
}
