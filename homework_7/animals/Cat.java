package animals;

public class Cat extends Animal {
    private final int maxDistantRun = 200;

    public Cat(String nameAnimal) {
        super(nameAnimal);
    }

    @Override
    public void run(int distance) {
        if (distance <= 0) {
            System.out.println("Distance cannot be less or equal 0");
        } else if (distance > maxDistantRun) {
            System.out.println(getNameAnimal() + " can\'t run more than " + maxDistantRun + " meters");
        } else super.run(distance);
    }

    @Override
    public void swim(int distance) {
        if (distance <= 0) {
            System.out.println("Distance cannot be less or equal 0");
        } else System.out.println(getNameAnimal() + " can\'t swim");
    }
}
