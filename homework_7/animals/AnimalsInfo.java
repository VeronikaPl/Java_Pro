package animals;

public class AnimalsInfo {
    public static void main(String[] args) {
        Animal dogJacky = new Dog("Jacky");
        Animal catBarsik = new Cat("Barsik");
        Animal catIris = new Cat("Iris");

        System.out.println("\tDogs:");
        dogJacky.run(510);
        dogJacky.swim(5);

        System.out.println("\tCats:");
        catBarsik.run(100);
        catBarsik.swim(3);
        catIris.run(210);
        catIris.swim(10);

        System.out.println("______________________________");
        System.out.println("Amount of animals is " + Animal.getAnimalsCount());
        System.out.println("Amount of cats is " + Cat.getCatsCount());
        System.out.println("Amount of dogs is " + Dog.getDogsCount());
    }
}
