package examples.first.exam01;

import java.util.List;

public interface LottoMachine {
    // 공을 45개 넣는다.
    public void put(List<LottoBall> balls);

    // 공을 섞는다.
    public void mix();

    // 공을 6개 뽑는다. (랜덤)
    public List<LottoBall> getBalls();
}
