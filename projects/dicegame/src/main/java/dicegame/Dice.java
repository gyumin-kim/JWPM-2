package dicegame;

public class Dice {
    private int face;

    public Dice(int face) {
        this.face = face;
    }

    public int getFace() {
        return (int)(Math.random() * face) + 1;
    }
}
