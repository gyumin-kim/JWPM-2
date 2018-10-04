package examples.first.exam01;

public class CalC {
    /**
     * 간단한 계산기
     */
    // 필드(속성)를 선언
    private int value;

    // 기본 생성자
    public CalC() {
        this.value = 0;
    }
    // 생성자
    public CalC(int value) {
        // 필드 value를 파라미터 value로 초기화한다.
        this.value = value;
    }

    /**
     * plusValue를 받아서 누적한다.
     * @param plusValue
     */
    public void plus(int plusValue) {
        this.value += plusValue;
    }

    public void minus(int minusValue) {
        this.value -= minusValue;
    }

    public void multiply(int multiplyValue) {
        this.value *= multiplyValue;
    }

    public void divide(int divideValue) {
        this.value /= divideValue;
    }

    public void clear() {
        this.value = 0;
    }

    /**
     * 내부적인 값을 반환한다.
     * @return
     */
    public int getValue() {
        return this.value;
    }
}
