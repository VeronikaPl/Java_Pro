package participants;

public class Competition {
    public static void start(Participant[] participants, Barrier[] barriers) {
        for (Participant part : participants) {
            for (Barrier barrier : barriers) {
                if (!barrier.overcome(part))
                    break;
            }
            System.out.println("-------------------------------------");
        }
    }
}
