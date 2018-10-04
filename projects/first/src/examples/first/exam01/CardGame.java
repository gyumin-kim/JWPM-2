package examples.first.exam01;

import java.util.ArrayList;
import java.util.List;

public class CardGame {
    public static void main(String[] args) {
        // 카드공장에서 카드를 생성한다.
        List<Card> cardList = CardFactory.createCards();

        // 플레이어 리스트를 생성한다.
        List<Player> playerList = new ArrayList<>();
        playerList.add(new Player("김과장"));
        playerList.add(new Player("이대리"));
        playerList.add(new Player("최주임"));

        // 딜러를 생성한다. (게임 시작, 카드 섞기, 판정하기 역할)
        Dealer dealer = new Dealer("박딜러");
        dealer.setCardList(cardList);
        dealer.setPlayerList(playerList);

        dealer.newGame();
        dealer.mix();
        dealer.shareCards();  // Player들에게 카드 분배
        dealer.result();
        dealer.judge();
    }
}
