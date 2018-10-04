package examples.first.exam01;

import java.util.List;

public class LottoMain {

    public static void main(String[] args) {
        // 로또볼 45개를 준비한다.
        List<LottoBall> list = LottoBallFactory.createBalls();

        // 로또머신에 넣는다
        LottoMachine machine = new NHLottoMachine();
        machine.put(list);

        // 로또머신의 로또볼을 섞는다
        machine.mix();

        // 섞인 볼들 중에서 6개를 꺼낸다.
        List<LottoBall> balls = machine.getBalls();
        for (LottoBall ball : balls) {
            System.out.print(ball.getNumber() + " ");
        }
    }
}
