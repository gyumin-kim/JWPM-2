package dicegame;

public class Player {
    private String name;
    private Dice dice;

    public Player() {
        System.out.println("Player()");
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDice(Dice dice) {
        this.dice = dice;
    }

    public String getName() {
        return name;
    }

    public Dice getDice() {
        return dice;
    }

    public int play() {
        int score = dice.getFace();
        System.out.println(name + ": " + score + "점입니다.");
        return score;
    }
}
