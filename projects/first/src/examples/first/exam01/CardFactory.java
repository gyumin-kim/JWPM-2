package examples.first.exam01;

import java.util.ArrayList;
import java.util.List;

public class CardFactory {

    private CardFactory() {}

    static List<Card> createCards() {
        List<Card> list = new ArrayList<>();
        String[] types = {"클로버", "하트", "다이아", "스페이스"};

        for (String type : types) {
            for (int i = 1; i <= 13; i++) {
                Card card = new Card(type, i);
                list.add(card);
            }
        }

        return list;
    }
}
