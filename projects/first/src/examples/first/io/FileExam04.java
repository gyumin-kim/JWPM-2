package examples.first.io;

import java.io.File;

public class FileExam04 {
    public static void main(String[] args) {
        File file1 = new File("/tmp/a/b/c/d/e");
        File file2 = new File("/tmp/test");

        if (!file1.exists()) {
            file1.mkdirs();  // file의 pathname의 해당하는 디렉토리를 몽땅(하위의 하위까지) 만든다.
            // file.mkdir()하면 안만들어짐.
        }
        if (!file2.exists()) {
            // mkdir()은 디렉토리(폴더) 하나만 만듬.
            // 두개 이상 안으로 들어가는 pathname을 가진 file에서 mkdir() 수행시 디렉토리 만들어지지 않음.
            file2.mkdir();
        }
    }
}
