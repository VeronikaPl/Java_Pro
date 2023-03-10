package animals;

public class Animal {
    private String nameAnimal;
    private static int animalsCount;
    private static int catsCount;
    private static int dogsCount;

    public Animal(String nameAnimal) {
        this.nameAnimal = nameAnimal;
        animalsCount++;
        if (this instanceof Cat) {
            catsCount++;
        } else if (this instanceof Dog) {
            dogsCount++;
        }
    }

    public String getNameAnimal() {
        return nameAnimal;
    }

    public void setNameAnimal(String nameAnimal) {
        this.nameAnimal = nameAnimal;
    }

    public static int getAnimalsCount() {
        return animalsCount;
    }

    public void setAnimalsCount(int animalsCount) {
        this.animalsCount = animalsCount;
    }

    public static int getCatsCount() {
        return catsCount;
    }

    public void setCatsCount(int catsCount) {
        this.catsCount = catsCount;
    }

    public static int getDogsCount() {
        return dogsCount;
    }

    public void setDogsCount(int dogsCount) {
        this.dogsCount = dogsCount;
    }

    public void run(int distance) {
        System.out.println(getNameAnimal() + " run " + distance + " meters");
    }

    public void swim(int distance) {
        System.out.println(getNameAnimal() + " swim " + distance + " meters");
    }
}
