package examples.first.io;

import java.io.File;

public class FileExam02 {
    public static void main(String[] args) throws Exception {
        // .은 현재 경로
        // .은 JVM이 실행 중인 경로를 말하는데, 클래스 경로가 아니라 프로젝트의 경로
        File file = new File(".");

        // 절대경로를 출력한다.
        // 절대경로는 /로 시작하거나, 드라이브명으로 시작한다.
        System.out.println(file.getAbsolutePath());
    }
}
