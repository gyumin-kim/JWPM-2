package dicegame;

import java.util.List;

public class Game {
    private List<Player> playerList;
    private Player firstPlayer;

    public Game() {
        System.out.println("Game()");
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }

    public void play() {
        int highScore = 0;
        for (Player player : playerList) {
            int score = player.play();
            if (score > highScore) {
                highScore = score;
                firstPlayer = player;
            }
        }
        System.out.println(firstPlayer.getName() + "이(가) " + highScore + "점으로 최고점을 기록하였습니다.");
    }
}
