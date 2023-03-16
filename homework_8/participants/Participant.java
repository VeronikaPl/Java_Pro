package participants;

public abstract class Participant {
    private String name;
    private double maxDistantRun;
    private double maxDistantJump;

    public Participant(String name, double maxDistantRun, double maxDistantJump) {
        this.name = name;
        this.maxDistantRun = maxDistantRun;
        this.maxDistantJump = maxDistantJump;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMaxDistantRun() {
        return maxDistantRun;
    }

    public void setMaxDistantRun(double maxDistantRun) {
        this.maxDistantRun = maxDistantRun;
    }

    public double getMaxDistantJump() {
        return maxDistantJump;
    }

    public void setMaxDistantJump(double maxDistantJump) {
        this.maxDistantJump = maxDistantJump;
    }

    public String run() {
        return getName() + " is running";
    }

    public String jump() {
        return getName() + " is jumping";
    }
}
