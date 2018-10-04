package examples.first.exam01;

import java.util.ArrayList;
import java.util.List;

public class LottoBallFactory {
    // 로또볼 공장은 여러개 있을 필요가 없다!
    private LottoBallFactory() {}

    // 로또볼 공장은 객체 안만들 것 --> static method
    public static List<LottoBall> createBalls() {
        List<LottoBall> list = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            LottoBall ball = new LottoBall(i);
            list.add(ball);
        }

        return list;
    }
}
