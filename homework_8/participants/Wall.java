package participants;

public class Wall extends Barrier {
    private double heigthWall;

    public Wall(String barrierName, double heigthWall) {
        super(barrierName);
        this.heigthWall = heigthWall;
    }

    public double getHeigthWall() {
        return heigthWall;
    }

    public void setHeigthWall(double heigthWall) {
        this.heigthWall = heigthWall;
    }

    @Override
    public boolean overcome(Participant participant) {
        System.out.println("Participant " + participant.jump() + " " + getBarrierName());
        if (getHeigthWall() <= participant.getMaxDistantJump()) {
            System.out.println("Participant " + participant.getName() + " passed " + getBarrierName() + " - " + getHeigthWall() + " meters");
            return true;
        } else {
            System.out.println("Participant " + participant.getName() + " didn\'n passed " + getBarrierName() + " - " + getHeigthWall()
                    + " meters. He/She passed only " + participant.getMaxDistantJump() + " meters.");
            return false;
        }
    }
}
