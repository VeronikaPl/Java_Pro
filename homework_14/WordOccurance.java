public class WordOccurance {
    private String name;
    private int occurance;

    public WordOccurance(String name, int occurance) {
        this.name = name;
        this.occurance = occurance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOccurance() {
        return occurance;
    }

    public void setOccurance(int occurance) {
        this.occurance = occurance;
    }

    @Override
    public String toString() {
        return "\n{" +
                "name:'" + name + '\'' +
                ", occurance: " + occurance +
                '}';
    }
}