package participants;

public class Racetrack extends Barrier {
    private double lengthRaceTrack;

    public Racetrack(String barrierName, double lengthRaceTrack) {
        super(barrierName);
        this.lengthRaceTrack = lengthRaceTrack;
    }

    public double getLengthRaceTrack() {
        return lengthRaceTrack;
    }

    public void setLengthRaceTrack(double lengthRaceTrack) {
        this.lengthRaceTrack = lengthRaceTrack;
    }

    @Override
    public boolean overcome(Participant participant) {
        System.out.println("Participant " + participant.run() + " " + getBarrierName());
        if (getLengthRaceTrack() <= participant.getMaxDistantRun()) {
            System.out.println("Participant " + participant.getName() + " passed " + getBarrierName() + " - " + getLengthRaceTrack() + " meters");
            return true;
        } else {
            System.out.println("Participant " + participant.getName() + " didn\'n passed " + getBarrierName() + " - " + getLengthRaceTrack()
                    + " meters. He/She passed only " + participant.getMaxDistantRun() + " meters.");
            return false;
        }
    }
}
