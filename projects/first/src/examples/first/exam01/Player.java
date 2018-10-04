package examples.first.exam01;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private List<Card> cardList;

    public Player(String name) {
        this.name = name;
        this.cardList = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public List<Card> getCardList() {
        return cardList;
    }

    public void clearMyCards() {
        this.cardList.clear();
    }

    public void addCard(Card card) {
        cardList.add(card);
    }
}
