package participants;

public abstract class Barrier {
    private String barrierName;

    public Barrier(String barrierName) {
        this.barrierName = barrierName;
    }

    public String getBarrierName() {
        return barrierName;
    }

    public void setBarrierName(String barrierName) {
        this.barrierName = barrierName;
    }

    public abstract boolean overcome(Participant participant);
}
