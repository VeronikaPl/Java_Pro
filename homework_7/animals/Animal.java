package animals;

public class Animal {
    private static int animalsCount;
    private String name;

    public Animal(String name) {
        this.name = name;
        animalsCount++;
    }

    public static int getAnimalsCount() {
        return animalsCount;
    }

    public void setAnimalsCount(int animalsCount) {
        this.animalsCount = animalsCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void run(int distance) {
        System.out.println(getName() + " run " + distance + " meters");
    }

    public void swim(int distance) {
        System.out.println(getName() + " swim " + distance + " meters");
    }
}
