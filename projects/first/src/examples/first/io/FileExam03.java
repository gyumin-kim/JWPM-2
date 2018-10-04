package examples.first.io;

import java.io.File;

public class FileExam03 {
    public static void main(String[] args) {
        File file = new File(".");
        File[] files = file.listFiles();    // 현재 경로에 있는 모든 파일 정보를 리턴

        // 모든 파일들에 대해, 디렉토리인지 파일인지 구별한다.
        for (File f : files) {
            if (f.isDirectory())
                System.out.println("[DIR] " + f.getAbsolutePath());
            else if (f.isHidden())
                System.out.println("[HIDDEN] " + f.getAbsolutePath());
            else
                System.out.println(f.getAbsolutePath());

//            if (f.isFile())
//                System.out.println(f.getAbsolutePath());
//            else
//                System.out.println("[DIR] " + f.getAbsolutePath());
        }
    }
}
