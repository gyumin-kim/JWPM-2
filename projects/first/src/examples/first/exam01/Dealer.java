package examples.first.exam01;

import java.util.Collections;
import java.util.List;

public class Dealer {
    private String name;
    private List<Player> playerList;
    private List<Card> cardList;
    private int index = 0;

    public Dealer(String name) {
        this.name = name;
        this.index = 0;
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }

    public void setCardList(List<Card> cardList) {
        this.cardList = cardList;
    }

    public void newGame() {
        index = 0;
        for (Player player : playerList) {
            player.clearMyCards();
        }
    }

    public void mix() {
        Collections.shuffle(cardList);
    }

    public Card getCard() {
        return cardList.get(index++);
    }

    public void shareCards() {
        for (int i = 0; i < 5; i++) {
            for (Player player : playerList) {
                player.addCard(getCard());
            }
        }
    }

    public void result(){
        for (Player player : playerList) {
            System.out.print(player.getName() + " ==> ");
            System.out.println(player.getCardList());
        }
    }

    public void judge() {
        int[] scores = new int[3];
        for (int i = 0; i < 3; i++) {
            List<Card> playerCardList = playerList.get(i).getCardList();
            for (Card card : playerCardList) {
                scores[i] += card.getNumber();
            }
        }
        for (int i = 0; i < 3; i++) {
            System.out.print(playerList.get(i).getName() + ": " + scores[i] + "점");
            System.out.println();
        }

        int max = 0;
        for (int i = 1; i < 3; i++)
            if (scores[i] > scores[max]) max = i;
        System.out.println(playerList.get(max).getName() + " 승!");
    }
}
