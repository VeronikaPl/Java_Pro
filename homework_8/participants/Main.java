package participants;

public class Main {
    public static void main(String[] args) {
        Participant[] participants = {
                new Human("John", 15, 0.5),
                new Cat("Iris", 20, 1),
                new Robot("GH-1782", 30, 0.7),
                new Human("Bella", 25, 1.1)
        };
        Barrier[] barriers = {
                new Racetrack("Race-track #1", 20),
                new Wall("Wall #1", 1),
                new Racetrack("Race-track #2", 25)
        };

        for (Participant part : participants) {
            for (Barrier barrier : barriers) {
                if (!barrier.overcome(part))
                    break;
            }
            System.out.println("-------------------------------------");
        }
    }
}
