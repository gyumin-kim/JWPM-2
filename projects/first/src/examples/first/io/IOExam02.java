package examples.first.io;

import java.io.*;

/**
 * "res/test.txt"으로부터 데이터를 읽어들여 "/tmp/readme.out"에 출력(copy)하되, 1024byte의 buffer 단위로 주고받는다.
 * []로 읽어서 []로 쓴다
 */
public class IOExam02 {
    public static void main(String[] args) {
        InputStream in = null;
        OutputStream out = null;

        try {
            File file = new File("res/test.txt");
            if (!file.isDirectory() && file.exists()) {
                in = new FileInputStream(file);
                out = new FileOutputStream("/tmp/readme.out");

                byte[] buffer = new byte[1024];
                int readCount = -1;
                while ((readCount = in.read(buffer)) != -1) {
                    out.write(buffer, 0, readCount);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException ex) {}
            try {
                out.close();
            } catch (IOException ex) {}
        }
    }
}
