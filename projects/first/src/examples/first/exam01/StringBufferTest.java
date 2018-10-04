package examples.first.exam01;

public class StringBufferTest {
    /**
     * 프로그램 시작점.
     * @param args
     */
    public static void main(String[] args) {
        // 스트링 버퍼를 사용
        StringBuffer sb = new StringBuffer();
        // append(): sb 안에 String을 저장한다
        sb.append("hello");
        sb.append(" ");
        sb.append("world!!");

        // toString(): sb 안에 있는 문자열을 꺼낸다(return)
        System.out.println(sb.toString());
    }
}