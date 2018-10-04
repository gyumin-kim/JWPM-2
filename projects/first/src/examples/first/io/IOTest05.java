package examples.first.io;

/**
 * 키보드로부터 "한줄 씩" 입력받아서 파일("/tmp/read.txt")에 한줄 씩 출력하시오
 * 1. 어디서 읽어들이는가? ==> 키보드 (System.in: 표준입력)
 * 2. 어디에 쓰는가? ==> 파일 (FileWriter: 파일에 char 단위 출력)
 * 3. 읽는 방법: 한줄 씩 입력받는다. (BufferedReader: readLine()을 사용하면 데이터를 라인 단위로 읽어올 수 있다)
 * 4. 쓰는 방법: "/tmp/read.txt"에 한줄 씩 쓴다. (PrintWriter)
 * quit라고 입력하면 프로그램은 종료된다.
 */
public class IOTest05 {
    public static void main(String[] args) {
    }
}
