package examples.first.io;

import java.io.File;

public class FileExam01 {
    public static void main(String[] args) {
        // 윈도우는 \, 유닉스 계열은 /가 사용됨.
        // 윈도우 ==> c:\\tmp\\파일명

        String fileName = "res/test.txt";
//         운영체제 독립적인 파일 경로를 지정하려면, File.separator('/'와 같음) 사용
        String pathName = "res" + File.separator + "test.txt";
        File file = new File(pathName);

        if (file.exists()) {
            System.out.println(pathName + "이 존재합니다");
        }
    }
}
