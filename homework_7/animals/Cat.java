package animals;

public class Cat extends Animal {
    private final int maxDistantRun = 200;
    private static int catsCount;

    public Cat(String name) {
        super(name);
        catsCount++;
    }

    public static int getCatsCount() {
        return catsCount;
    }

    public void setCatsCount(int catsCount) {
        this.catsCount = catsCount;
    }

    @Override
    public void run(int distance) {
        if (distance <= 0) {
            System.out.println("Distance cannot be less or equal 0");
        } else if (distance > maxDistantRun) {
            System.out.println(getName() + " can\'t run more than " + maxDistantRun + " meters");
        } else super.run(distance);
    }

    @Override
    public void swim(int distance) {
        if (distance <= 0) {
            System.out.println("Distance cannot be less or equal 0");
        } else System.out.println(getName() + " can\'t swim");
    }
}
