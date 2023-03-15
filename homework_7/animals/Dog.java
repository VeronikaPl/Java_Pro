package animals;

public class Dog extends Animal {
    private final int maxDistantRun = 500;
    private final int maxDistantSwim = 10;
    private static int dogsCount;

    public Dog(String name) {
        super(name);
        dogsCount++;
    }

    public static int getDogsCount() {
        return dogsCount;
    }

    public void setDogsCount(int dogsCount) {
        this.dogsCount = dogsCount;
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
        } else if (distance > maxDistantSwim) {
            System.out.println(getName() + " can\'t swim more than " + maxDistantSwim + " meters");
        } else super.swim(distance);
    }
}
